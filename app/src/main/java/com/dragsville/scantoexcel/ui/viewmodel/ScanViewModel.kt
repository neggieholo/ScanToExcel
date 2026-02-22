package com.dragsville.scantoexcel.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dragsville.scantoexcel.data.models.ScanResult
import com.dragsville.scantoexcel.data.repository.ScanRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ScanViewModel(
    private val repository: ScanRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _scans = MutableStateFlow<List<ScanResult>>(emptyList())
    val scans: StateFlow<List<ScanResult>> = _scans

    fun loadScans() {
        viewModelScope.launch {
            _scans.value = repository.getAllScans()
        }
    }

    fun addFakeScan() {
        viewModelScope.launch {
            val scan = ScanResult(
                id = System.currentTimeMillis(),
                filePath = "dummy/path.jpg",
                timestamp = System.currentTimeMillis()
            )
            repository.saveScan(scan)
            loadScans()
        }
    }
}