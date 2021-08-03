package com.raywenderlich.android.busso.di

import android.app.Activity
import com.raywenderlich.android.busso.di.scopes.ActivityScope
import com.raywenderlich.android.busso.ui.view.main.MainActivity
import com.raywenderlich.android.busso.ui.view.splash.SplashActivity
import com.raywenderlich.android.ui.navigation.Navigator
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class]// 1
)
@ActivityScope // 2
interface ActivityComponent {

    fun inject(activity: SplashActivity) // 3

    fun inject(activity: MainActivity) // 3

    fun navigator(): Navigator // 4

    @Component.Factory
    interface Factory {
        // 5
        fun create(
            @BindsInstance activity: Activity,
            applicationComponent: ApplicationComponent
        ): ActivityComponent
    }
}
