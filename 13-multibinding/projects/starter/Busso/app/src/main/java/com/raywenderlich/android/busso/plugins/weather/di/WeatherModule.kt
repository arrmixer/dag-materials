package com.raywenderlich.android.busso.plugins.weather.di

import com.raywenderlich.android.busso.di.scopes.ApplicationScope
import com.raywenderlich.android.busso.plugins.api.InformationEndpoint
import com.raywenderlich.android.busso.plugins.api.InformationPluginSpec
import com.raywenderlich.android.busso.plugins.weather.endpoint.WeatherEndpoint
import com.raywenderlich.android.busso.plugins.weather.endpoint.WeatherInformationEndpoint
import com.raywenderlich.android.busso.plugins.weather.endpoint.WeatherInformationEndpointImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import retrofit2.Retrofit
import javax.inject.Named

const val WEATHER_INFO_NAME = "Weather"

@Module(includes = [WeatherModule.Bindings::class])
object WeatherModule {

    @Provides
    @ApplicationScope
    fun provideWeatherEndpoint(retrofit: Retrofit): WeatherEndpoint {
        return retrofit.create(WeatherEndpoint::class.java)
    }

    @Provides
    @Named(WEATHER_INFO_NAME)
    @ApplicationScope
    fun provideWeatherSpec(endpoint: WeatherInformationEndpoint): InformationPluginSpec = object : InformationPluginSpec {
        override val informationEndpoint: InformationEndpoint
            get() = endpoint
        override val serviceName: String
            get() = "Weather"

    }

    @Module
    interface Bindings {

        @Binds
        fun bindWeatherInformationEndpoint(
            impl: WeatherInformationEndpointImpl
        ): WeatherInformationEndpoint
    }
}
