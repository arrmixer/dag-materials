package com.raywenderlich.android.raytracker.di.custom

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ActivityComponent

@DefineComponent(parent = ActivityComponent::class) // 1
@TrackRunningScoped // 2
interface TrackRunningComponent{

    @DefineComponent.Builder // 3
    interface Builder {
        fun sessionId(@BindsInstance sessionId: Long): Builder // 4
        fun build(): TrackRunningComponent // 5
    }
}

/*
1. @DefineComponent to add a new @Component to the ones Hilt supports. Its parent attribute is fundamental because it allows you to choose
    where in the existing hierarchy to add your @Component. In this case, you’re adding TrackRunningComponent as a child of ActivityComponent.
    You’re extending the @Component hierarchy, as shown in Figure 18.9.
2. @TrackRunningScoped as the @Scope that binds objects to the lifecycle of TrackRunningComponent.
3. Use @DefineComponent.Builder to define the abstraction of the Builder you’ll use to create the specific TrackRunningComponent instance.
4. Provide an object that will be part of the @TrackRunningComponent dependency graph.
    In this case, it’s a simple Long representing the concept of session. This is just an example.
    In your @DefineComponent.Builder, you might provide more objects, or none at all.
5. Define a build() that must have TrackRunningComponent as the return type. It’s similar to @Component.Builder and @Subcomponent.Builder,
    which you learned about in previous chapters.
*/
