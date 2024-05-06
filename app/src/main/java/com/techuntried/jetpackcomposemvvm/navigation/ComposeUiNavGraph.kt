package com.techuntried.jetpackcomposemvvm.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.techuntried.jetpackcomposemvvm.screens.composeui.AlertDialogScreen
import com.techuntried.jetpackcomposemvvm.screens.composeui.BottomNavScreen
import com.techuntried.jetpackcomposemvvm.screens.composeui.BottomSheetScreen
import com.techuntried.jetpackcomposemvvm.screens.composeui.CanvasScreen
import com.techuntried.jetpackcomposemvvm.screens.composeui.CoilScreen
import com.techuntried.jetpackcomposemvvm.screens.composeui.ComposeUiScreen
import com.techuntried.jetpackcomposemvvm.screens.composeui.FloatingScreen
import com.techuntried.jetpackcomposemvvm.screens.composeui.ImagePickerScreen


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
        composable(ComposeUiScreens.BottomSheetScreen.route) {
            BottomSheetScreen()
        }
        composable(Graphs.BottomBarGraph) {
            BottomNavScreen()
        }
    }
}
