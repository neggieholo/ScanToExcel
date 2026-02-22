package com.dragsville.scantoexcel.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ScanDao {

    @Insert
    suspend fun insert(scan: ScanEntity)

    @Query("SELECT * FROM scans ORDER BY timestamp DESC")
    suspend fun getAll(): List<ScanEntity>
}