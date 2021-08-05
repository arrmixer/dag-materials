package com.raywenderlich.android.busso.di

import android.text.style.TtsSpan
import com.raywenderlich.android.busso.di.activities.ActivityModule
import com.raywenderlich.android.busso.di.fragments.FragmentBindingModule
import com.raywenderlich.android.busso.ui.view.main.MainActivity
import com.raywenderlich.android.busso.ui.view.splash.SplashActivity
import com.raywenderlich.android.di.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule { // 1 this handles the android injections

    @ContributesAndroidInjector(  // 3
        modules = [
            ActivityModule::class,
            FragmentBindingModule::class // 5
        ]
    )
    @ActivityScope // 4
    fun mainActivity(): MainActivity // 2

    @ContributesAndroidInjector(  // 3
        modules = [
            ActivityModule::class
        ]
    )
    @ActivityScope
    fun splashActivity(): SplashActivity // 2
}

/*
1. Define a simple Dagger @Module, implemented as an interface.
2. Create an abstract function that has the injection target type as the return type. In this case, mainActivity() returns MainActivity and splashActivity() returns SplashActivity.
3. Use @ContributesAndroidInjector to ask Dagger Android to generate the @Subcomponent and @Module, which, until now, you had to write yourself. The @Modules you define here become the @Modules you use in the related @Subcomponents.
4. Bind the object in the @Subcomponent to a @Scope.
5. Add FragmentBindingModule (fragments) to mainActivity
*/
