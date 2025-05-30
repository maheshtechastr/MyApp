package com.mpg.myapp.activity

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mpg.myapp.viewmodel.HomeScreenViewModel

private const val TAG = "HomeScreen"

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = viewModel()) {
    val username by viewModel.username.collectAsState()
    val context = LocalContext.current
    val toastMessage by viewModel.toastMessage.collectAsState()

    LaunchedEffect(toastMessage) {
        if (toastMessage.isNotEmpty()) {
            Log.i(TAG, "HomeScreen: $toastMessage")
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        // Create references for the composables
        val (box1, box2, text, txtUserName, btnSubmit) = createRefs()

        // First Box
        Box(
            modifier = Modifier
                .background(Color.Red)
                .constrainAs(box1) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
                .size(100.dp)
        )

        // Second Box
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .constrainAs(box2) {
                    top.linkTo(box1.bottom, margin = 16.dp)
                    start.linkTo(box1.end, margin = 16.dp)
                }
                .size(100.dp)
        )

        // Text
        BasicText(
            text = "Hello, ConstraintLayout!",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(box2.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        OutlinedTextField(
            value = username,
            onValueChange = { viewModel.updateUsername(it) },
            modifier = Modifier
                .constrainAs(txtUserName) {
                    top.linkTo(text.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .border(1.dp, color = Color.Gray),
            label = { Text("Enter your username") }
        )
        Button(
            onClick = {
            /* Perform action */
                viewModel.showToastMessage(username)
        },
            modifier = Modifier
                .constrainAs(btnSubmit) {
                    top.linkTo(txtUserName.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .border(1.dp, color = Color.Gray)
        ) {
            Text("Click Me")
        }

    }
}
