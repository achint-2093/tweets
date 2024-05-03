package com.techuntried.jetpackcomposemvvm


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.techuntried.jetpackcomposemvvm.navigation.Screens
import com.techuntried.jetpackcomposemvvm.screens.CategoryScreen
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
                                   ).show()}) {
                                   Icon(Icons.Default.Face,"fa")
                               }

                                IconButton(onClick = {}) {
                                   Icon(Icons.Default.MoreVert,"fa")
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
            CategoryScreen {
                navController.navigate("tweets/$it")
            }
        }
        composable(Screens.TweetsScreen.route, arguments = listOf(
            navArgument("category") {
                type = NavType.StringType
            }
        )) {
            TweetsScreen()
        }
    }
}

