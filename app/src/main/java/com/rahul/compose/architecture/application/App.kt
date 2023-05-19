package com.rahul.compose.architecture.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (Config.environment.debugLogsEnabled) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
