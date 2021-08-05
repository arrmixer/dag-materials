package com.raywenderlich.android.busso.di.activities.main

/* not needed if using @ContributesAndroidInjector
import com.raywenderlich.android.busso.di.activities.ActivityModule
import com.raywenderlich.android.busso.di.fragments.busarrival.BusArrivalFragmentModule
import com.raywenderlich.android.busso.di.fragments.busstop.BusStopFragmentModule
import com.raywenderlich.android.busso.ui.view.main.MainActivity
import com.raywenderlich.android.di.scopes.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [
        ActivityModule::class, // 1
        BusStopFragmentModule::class,
        BusArrivalFragmentModule::class
    ]
)
@ActivityScope // 2
interface MainActivitySubcomponent : AndroidInjector<MainActivity> { // 3

    @Subcomponent.Factory // 4
    interface Factory : AndroidInjector.Factory<MainActivity> // 5
}*/
