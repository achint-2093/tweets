package com.techuntried.jetpackcomposemvvm.navigation

sealed class Screens(val route:String){
    object CategoryScreen:Screens("category")
    object TweetsScreen:Screens("tweets/{category}")
    object SettingsScreen:Screens("settings")
}
