package com.techuntried.jetpackcomposemvvm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.techuntried.jetpackcomposemvvm.screens.AlertDialogScreen
import com.techuntried.jetpackcomposemvvm.screens.BottomNavScreen
import com.techuntried.jetpackcomposemvvm.screens.CanvasScreen
import com.techuntried.jetpackcomposemvvm.screens.CoilScreen
import com.techuntried.jetpackcomposemvvm.screens.ComposeUiScreen
import com.techuntried.jetpackcomposemvvm.screens.FloatingScreen
import com.techuntried.jetpackcomposemvvm.screens.ImagePickerScreen
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
