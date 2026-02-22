package com.dragsville.scantoexcel

import android.app.Application
import com.dragsville.scantoexcel.data.local.ScanAppDataContainer
import com.dragsville.scantoexcel.data.local.ScanContainer

class ScanApplication : Application() {

    // App container instance available globally
    lateinit var appContainer: ScanContainer
        private set

    override fun onCreate() {
        super.onCreate()

        // Initialize container here with app context
        appContainer = ScanAppDataContainer(this)
    }
}

