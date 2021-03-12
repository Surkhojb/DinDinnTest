package com.surkhojb.dindinntest

import android.app.Application
import com.airbnb.mvrx.Mavericks
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DinDinnApp : Application(){

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}