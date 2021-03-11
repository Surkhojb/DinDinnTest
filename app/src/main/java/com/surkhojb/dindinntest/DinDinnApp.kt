package com.surkhojb.dindinntest

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class DinDinnApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)
    }
}