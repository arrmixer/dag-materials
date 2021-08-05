package com.raywenderlich.android.raytracker.logging

import android.util.Log
import com.raywenderlich.android.raytracker.di.custom.TrackRunningScoped
import javax.inject.Inject

@TrackRunningScoped // 1
class HiltLogger @Inject constructor() {
    fun log(message: String) {
        Log.d("HILT_LOGGING", "$this -> $message") // 2
    }
}
