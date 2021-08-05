package com.raywenderlich.android.raytracker.di.custom

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped // 1
class TrackRunningComponentManager @Inject constructor(
    private val trackRunnningBuilder: TrackRunningComponent.Builder // 2
) {

    var trackRunningComponent: TrackRunningComponent? = null // 3

    fun startWith(sessionId: Long) { // 4
        if (trackRunningComponent == null) {
            trackRunningComponent = trackRunnningBuilder
                .sessionId(sessionId)
                .build()
        }
    }

    fun stop() {
        if (trackRunningComponent != null) {
            trackRunningComponent = null // 5
        }
    }
}

/*
1. Use @ActivityScoped to bind the lifecycle of TrackRunningComponentManager to Activity’s lifecycle.
    This needs to be the one you specify as parent in the TrackRunningComponent definition.
2. Inject the reference to TrackRunningComponent.Builder.
3. Define trackRunningComponent, which will contain the reference to the current
    TrackRunningComponent implementation instance.
4. Provide startWith() when you use TrackRunningComponent.Builder,
    which creates the TrackRunningComponent instance to store in trackRunningComponent.
5. Provide stop() to reset TrackRunningComponent.
*/
