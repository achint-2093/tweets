package com.techuntried.jetpackcomposemvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.techuntried.jetpackcomposemvvm.screens.AlertDialogScreen
import com.techuntried.jetpackcomposemvvm.screens.BottomNavScreen
import com.techuntried.jetpackcomposemvvm.screens.CanvasScreen
import com.techuntried.jetpackcomposemvvm.screens.CoilScreen
import com.techuntried.jetpackcomposemvvm.screens.ComposeUiScreen
import com.techuntried.jetpackcomposemvvm.screens.FloatingScreen
import com.techuntried.jetpackcomposemvvm.screens.ImagePickerScreen


fun NavGraphBuilder.composeUiNavGraph(navController: NavController) {
    navigation(route = Graphs.ComposeGraph, startDestination = Screens.ComposeUiScreen.route) {
        composable(Screens.ComposeUiScreen.route) {
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
        composable(Graphs.BottomBarGraph) {
            BottomNavScreen()
        }
    }
}
