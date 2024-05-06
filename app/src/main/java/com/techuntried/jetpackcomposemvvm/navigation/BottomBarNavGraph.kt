package com.techuntried.jetpackcomposemvvm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.techuntried.jetpackcomposemvvm.screens.bottomnav.HomeScreen
import com.techuntried.jetpackcomposemvvm.screens.bottomnav.ProfileScreen
import com.techuntried.jetpackcomposemvvm.screens.bottomnav.SearchScreen


@Composable
fun BottomNavGraph(navController: NavHostController,modifier: Modifier) {
    NavHost(navController=navController ,startDestination = BottomBarScreens.HomeScreen.route, route = Graphs.BottomBarGraph) {
        composable(BottomBarScreens.HomeScreen.route) {
            HomeScreen()
        }
        composable(BottomBarScreens.ProfileScreen.route) {
            ProfileScreen()
        }
        composable(BottomBarScreens.SearchScreen.route) {
            SearchScreen()
        }

    }
}
