package dev.sandul.blackmasterminitodo.main_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.unit.dp

@Composable
fun AddNewTask(
    tasks: SnapshotStateList<String>,
    focusManager: FocusManager
) {
    var text by remember { mutableStateOf("") }
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Нове завдання") },
            modifier = Modifier.weight(1f),
            singleLine = true,
            maxLines = 1,
            placeholder = { Text("Введіть завдання") },
            shape = RoundedCornerShape(8.dp),
            keyboardActions = KeyboardActions(
                onDone = {
                    if (text.isNotBlank()) {
                        tasks.add(0, text.trim())
                        text = ""
                        focusManager.clearFocus()
                    }
                }
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        AddNewTaskButton(text, tasks, focusManager)
    }
}

//TODO refactor this function
@Composable
private fun AddNewTaskButton(
    textTemp: String,
    tasks: SnapshotStateList<String>,
    focusManager: FocusManager
) {
    Button(onClick = {
        if (textTemp.isNotBlank()) {
            tasks.add(0, textTemp.trim())
            textTemp = ""
            focusManager.clearFocus()
        }
    }) { Text(text = "+") }
}