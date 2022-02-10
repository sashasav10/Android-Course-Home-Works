package com.savelievoleksandr.p13

import android.app.Application
import com.google.android.gms.maps.MapsInitializer
import com.google.android.libraries.places.api.Places

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        MapsInitializer.initialize(applicationContext, MapsInitializer.Renderer.LATEST, null)
        Places.initialize(this, "Api_Key")
    }
}