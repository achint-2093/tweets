package com.techuntried.jetpackcomposemvvm.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation


fun NavGraphBuilder.navDrawerGraph(navController: NavController) {
    navigation(route = Graphs.NavDrawerGraph, startDestination = ComposeUiScreens.ComposeUiScreen.route) {

    }
}
