package dev.sandul.blackmasterminitodo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import dev.sandul.blackmasterminitodo.main_screen.AddNewTask
import dev.sandul.blackmasterminitodo.main_screen.ListOfTasks

@Composable
fun MiniToDoListScreen(modifier: Modifier = Modifier) {
    val tasks = remember { mutableStateListOf<String>() }
    val focusManager = LocalFocusManager.current
    val scope = rememberCoroutineScope()

    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        AddNewTask(tasks, focusManager)
        Spacer(modifier = Modifier.height(8.dp))
        ListOfTasks(tasks, scope)
    }
}