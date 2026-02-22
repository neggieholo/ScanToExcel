package com.dragsville.scantoexcel.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dragsville.scantoexcel.ui.viewmodel.ScanViewModel

@Composable
fun HomeScreen(viewModel: ScanViewModel) {

    val scans by viewModel.scans.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Recent Scans", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow {
            items(scans.take(10)) { scan ->
                Card(
                    modifier = Modifier
                        .size(120.dp)
                        .padding(end = 8.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Scan\n${scan.id}")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Exported Documents", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Changed from fixed height to weight for better scrolling
        ) {
            items(scans) { scan ->
                ListItem(
                    headlineContent = { Text("Document ${scan.id}") },
                    supportingContent = { Text(scan.filePath) }
                )
                HorizontalDivider()
            }
        }
    }
}
