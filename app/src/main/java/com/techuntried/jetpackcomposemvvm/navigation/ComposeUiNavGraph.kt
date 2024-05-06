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
    navigation(route = Graphs.ComposeGraph, startDestination = ComposeUiScreens.ComposeUiScreen.route) {
        composable(ComposeUiScreens.ComposeUiScreen.route) {
            ComposeUiScreen(navController)
        }
        composable(ComposeUiScreens.CanvasScreen.route) {
            CanvasScreen()
        }
        composable(ComposeUiScreens.CoilScreen.route) {
            CoilScreen()
        }
        composable(ComposeUiScreens.ImagePickerScreen.route) {
            ImagePickerScreen()
        }
        composable(ComposeUiScreens.AlertDialogScreen.route) {
            AlertDialogScreen()
        }
        composable(ComposeUiScreens.FloatingScreen.route) {
            FloatingScreen()
        }
        composable(Graphs.BottomBarGraph) {
            BottomNavScreen()
        }
    }
}
