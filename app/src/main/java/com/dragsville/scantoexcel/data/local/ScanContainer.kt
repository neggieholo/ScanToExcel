package com.dragsville.scantoexcel.data.local

import android.content.Context
import com.dragsville.scantoexcel.data.repository.ScanRepository
import com.dragsville.scantoexcel.data.repository.ScanRepositoryImpl


interface ScanContainer {
    val ScanRepository: ScanRepository
}

class ScanAppDataContainer(private val context: Context) : ScanContainer {
    override val ScanRepository: ScanRepository by lazy {
        ScanRepositoryImpl(ScanDatabase.getDatabase(context).scanDao())
    }
}