package com.dragsville.scantoexcel.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.dragsville.scantoexcel.ScanApplication
import com.dragsville.scantoexcel.ui.viewmodel.ScanViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Scan app
 */
object ScanViewModelProvider {

    val Factory = viewModelFactory {
        initializer {
            ScanViewModel(
                scanApplication().appContainer.ScanRepository,
                this.createSavedStateHandle()
            )
        }
    }
}

/**
 * Extension function to get [ScanApplication] from CreationExtras
 */
fun CreationExtras.scanApplication(): ScanApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ScanApplication)