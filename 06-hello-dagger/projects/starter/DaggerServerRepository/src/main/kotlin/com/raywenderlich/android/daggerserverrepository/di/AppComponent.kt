package com.raywenderlich.android.daggerserverrepository.di

import com.raywenderlich.android.daggerserverrepository.Server
import dagger.Component

// 1
@Component(modules = [MainModule::class])
// 2
interface AppComponent {
    // 3
    fun server(): Server
}

