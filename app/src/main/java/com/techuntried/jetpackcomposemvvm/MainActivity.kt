package com.techuntried.jetpackcomposemvvm


import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.techuntried.jetpackcomposemvvm.navigation.Screens
import com.techuntried.jetpackcomposemvvm.screens.AlertDialogScreen
import com.techuntried.jetpackcomposemvvm.screens.CanvasScreen
import com.techuntried.jetpackcomposemvvm.screens.CategoryScreen
import com.techuntried.jetpackcomposemvvm.screens.CoilScreen
import com.techuntried.jetpackcomposemvvm.screens.ComposeUiScreen
import com.techuntried.jetpackcomposemvvm.screens.FloatingScreen
import com.techuntried.jetpackcomposemvvm.screens.ImagePickerScreen
import com.techuntried.jetpackcomposemvvm.screens.TweetsScreen
import com.techuntried.jetpackcomposemvvm.ui.theme.JetpackComposeMvvmTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeMvvmTheme(false) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Tweets") },
                            actions = {
                                IconButton(onClick = {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "hi",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }) {
                                    Icon(Icons.Default.Face, "")
                                }

                                IconButton(onClick = {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "more",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }) {
                                    Icon(Icons.Default.MoreVert, "")
                                }
                            }
                        )
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        App()
                    }
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.CategoryScreen.route) {
        composable(Screens.CategoryScreen.route) {
            CategoryScreen(navController)
        }
        composable(Screens.TweetsScreen.route, arguments = listOf(
            navArgument("category") {
                type = NavType.StringType
            }
        )) {
            TweetsScreen()
        }

        composable(Screens.ComposeUiScreen.route, arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
                nullable = true
            }
        )) {
            Log.d("MYDEBUG", "${it.arguments?.getString("name")}")
            ComposeUiScreen(navController)
        }
        composable(Screens.CanvasScreen.route) {
            CanvasScreen()
        }
        composable(Screens.CoilScreen.route) {
            CoilScreen()
        }
        composable(Screens.ImagePickerScreen.route) {
            ImagePickerScreen()
        }
        composable(Screens.AlertDialogScreen.route) {
            AlertDialogScreen()
        }
        composable(Screens.FloatingScreen.route) {
            FloatingScreen()
        }
    }
}

