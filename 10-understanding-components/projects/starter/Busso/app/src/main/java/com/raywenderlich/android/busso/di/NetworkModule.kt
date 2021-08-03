package com.raywenderlich.android.busso.di

import android.app.Activity
import android.content.Context
import com.google.gson.GsonBuilder
import com.raywenderlich.android.busso.conf.BUSSO_SERVER_BASE_URL
import com.raywenderlich.android.busso.network.BussoEndpoint
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private val CACHE_SIZE = 100 * 1024L // 100K

@Module
class NetworkModule { // HERE

    @Provides
    fun provideBussoEndPoint(activity: Activity): BussoEndpoint {
        val cache = Cache(activity.cacheDir, CACHE_SIZE)
        val okHttpClient = OkHttpClient.Builder()
            .cache(cache)
            .build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BUSSO_SERVER_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()
                )
            )
            .client(okHttpClient)
            .build()
        return retrofit.create(BussoEndpoint::class.java)
    }
}
