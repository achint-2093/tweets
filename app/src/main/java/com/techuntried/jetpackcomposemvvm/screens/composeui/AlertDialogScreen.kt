package com.techuntried.jetpackcomposemvvm.screens.composeui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun AlertDialogScreen() {
    val openAlertDialog = remember {
        mutableStateOf(false)
    }
    val openProgressDialog = remember {
        mutableStateOf(false)
    }
    when (openProgressDialog.value) {
        true -> {
            ShowProgressDialog(openProgressDialog)
        }

        false -> {

        }
    }
    val openRadioDialog = remember {
        mutableStateOf(false)
    }
    when (openRadioDialog.value) {
        true -> {
            ShowRadioDialog(openRadioDialog)
        }

        false -> {

        }
    }
    when (openAlertDialog.value) {
        true -> ShowAlertDialog(openAlertDialog)
        false -> {}
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { openAlertDialog.value = !openAlertDialog.value }) {
            Text(text = "Show Alert Dialog")
        }
        Button(onClick = { openProgressDialog.value = !openProgressDialog.value }) {
            Text(text = "Progress Dialog")
        }
        Button(onClick = { openRadioDialog.value = !openRadioDialog.value }) {
            Text(text = "Radio Dialog")
        }
    }

}

@Composable
fun ShowAlertDialog(openAlertDialog: MutableState<Boolean>) {
    AlertDialog(
        title = { Text(text = "title") },
        dismissButton = {
            TextButton(onClick = { openAlertDialog.value = false }) {
                Text(text = "cancel")
            }
        },
        confirmButton = {
            TextButton(onClick = { openAlertDialog.value = false }) {
                Text(text = "confirm")
            }
        },
        text = { Text(text = "this is text") },
        onDismissRequest = { openAlertDialog.value = false })

}

@Composable
fun ShowProgressDialog(openProgressDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openProgressDialog.value = false }) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

    }
}

@Composable
fun ShowRadioDialog(openRadioDialog: MutableState<Boolean>) {
    var selected by remember {
        mutableStateOf(false)
    }
    Dialog(onDismissRequest = { }) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp)),
        ) {
            RadioButtonSample()
        }
    }
}

@Composable
fun RadioButtonSample() {
    val radioOptions = listOf("A", "B", "C")

    val (selectedOption: String, onOptionSelected: (String) -> Unit) = remember { mutableStateOf("") }
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.titleLarge.merge(),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            TextButton(onClick = {}) {
                Text(text = "cancel")
            }
            TextButton(onClick = {}) {
                Text(text = "okay")
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun dia() {
    val value = remember {
        mutableStateOf(false)
    }
    RadioButtonSample()
}

