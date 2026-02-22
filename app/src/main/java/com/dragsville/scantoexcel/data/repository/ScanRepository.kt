package com.dragsville.scantoexcel.data.repository
import com.dragsville.scantoexcel.data.models.ScanResult

interface ScanRepository {
    suspend fun saveScan(result: ScanResult)
    suspend fun getAllScans(): List<ScanResult>
}