package com.techuntried.jetpackcomposemvvm.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreens(val route: String, val title: String, val icon: ImageVector) {
    object HomeScreen : BottomBarScreens("home","Home", Icons.Filled.Home)
    object ProfileScreen : BottomBarScreens("profile","Profile",Icons.Filled.Person)
    object SearchScreen : BottomBarScreens("search","Search",Icons.Filled.Search)
}
