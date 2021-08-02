package com.raywenderlich.android.raysequence.di

import dagger.Module
import dagger.Provides
import kotlin.random.Random

@Module
class RandomModule {

    @Provides
    fun provideRandomInt(): Int = Random.nextInt()
}
