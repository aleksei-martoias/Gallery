package io.alekseimartoyas.webgallery

import android.app.Application
import io.alekseimartoyas.webgallery.DI.AppComponent
import io.alekseimartoyas.webgallery.DI.DaggerAppComponent

class MyApp: Application() {
    companion object {
        lateinit var graph: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        graph = DaggerAppComponent.builder().build()
    }
}