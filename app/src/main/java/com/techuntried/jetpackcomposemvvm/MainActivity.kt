package com.techuntried.jetpackcomposemvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.techuntried.jetpackcomposemvvm.api.TweetsApi
import com.techuntried.jetpackcomposemvvm.screens.CategoryScreen
import com.techuntried.jetpackcomposemvvm.screens.TweetsScreen
import com.techuntried.jetpackcomposemvvm.ui.theme.JetpackComposeMvvmTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeMvvmTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {
        composable("category") {
            CategoryScreen{
                navController.navigate("tweets/${it}")
            }
        }
        composable("tweets/{category}", arguments = listOf(
            navArgument("category") {
                type = NavType.StringType
            }
        )) {
            TweetsScreen()
        }
    }
}

