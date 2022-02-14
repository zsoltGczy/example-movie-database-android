package com.gzslt.examplemoviedatabase

import android.app.Application
import logcat.AndroidLogcatLogger
import logcat.LogPriority

class ExampleMovieDatabaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.VERBOSE)
    }
}
