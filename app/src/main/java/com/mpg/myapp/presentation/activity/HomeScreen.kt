package com.mpg.myapp.activity

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
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
//import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mpg.myapp.presentation.viewmodel.HomeScreenViewModel

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
        val (txtUserName, btnSubmit) = createRefs()

        OutlinedTextField(
            value = username,
            onValueChange = { viewModel.updateUsername(it) },
            modifier = Modifier
                .constrainAs(txtUserName) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
               // .border(1.dp, color = Color.Gray)
            ,
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
                //.border(1.dp, color = Color.Gray)
        ) {
            Text("Click Me")
        }

    }
}
