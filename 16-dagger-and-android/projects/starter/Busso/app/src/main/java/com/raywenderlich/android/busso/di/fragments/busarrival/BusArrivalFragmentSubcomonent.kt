package com.raywenderlich.android.busso.di.fragments.busarrival

/* not needed if using @ContributesAndroidInjector
import com.raywenderlich.android.busso.di.fragments.FragmentModule
import com.raywenderlich.android.busso.ui.view.busarrival.BusArrivalFragment
import com.raywenderlich.android.di.scopes.FragmentScope
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [
        FragmentModule::class
    ]
)
@FragmentScope
interface BusArrivalFragmentSubcomponent : AndroidInjector<BusArrivalFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<BusArrivalFragment> {

        override fun create(@BindsInstance instance: BusArrivalFragment): BusArrivalFragmentSubcomponent
    }
}*/
