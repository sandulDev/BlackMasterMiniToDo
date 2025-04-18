package dev.sandul.blackmasterminitodo.main_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ColumnScope.ListOfTasks(
    tasks: SnapshotStateList<String>,
    scope: CoroutineScope
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(tasks.size) { index ->
            AnimatedVisibility(visible = true) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable { deleteTask(scope, tasks, index) }) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp), text = tasks[index]
                    )
                }
            }
        }
    }
}

private fun deleteTask(
    scope: CoroutineScope,
    tasks: SnapshotStateList<String>,
    index: Int
) {
    scope.launch {
        delay(300)
        tasks.removeAt(index)
    }
}