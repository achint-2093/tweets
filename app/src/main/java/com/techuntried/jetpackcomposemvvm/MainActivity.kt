package com.techuntried.jetpackcomposemvvm


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.techuntried.jetpackcomposemvvm.navigation.ComposeUiScreens
import com.techuntried.jetpackcomposemvvm.navigation.Screens
import com.techuntried.jetpackcomposemvvm.navigation.composeUiNavGraph
import com.techuntried.jetpackcomposemvvm.screens.CategoryScreen
import com.techuntried.jetpackcomposemvvm.screens.TweetsScreen
import com.techuntried.jetpackcomposemvvm.ui.theme.JetpackComposeMvvmTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeMvvmTheme(false) {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        Toolbar(navController)
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        App(navController)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(navController: NavHostController) {
    val destination: NavDestination? =
        navController.currentBackStackEntryAsState().value?.destination
    val title = when (destination?.route) {
        Screens.CategoryScreen.route -> "Categories"
        Screens.TweetsScreen.route -> "Tweets"
        ComposeUiScreens.ComposeUiScreen.route -> "Compose Components"

        else -> {
            "Title"
        }
    }
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            if (destination?.route != Screens.TweetsScreen.route) {
                IconButton(onClick = {
                    Toast.makeText(
                        context,
                        title,
                        Toast.LENGTH_SHORT
                    ).show()
                }) {
                    Icon(Icons.Default.Face, "")
                }
            }

            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "fav",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(Icons.Default.Favorite, "")
            }

        }
    )
}

@Composable
fun App(navController: NavHostController) {
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
        composeUiNavGraph(navController = navController)
    }
}

