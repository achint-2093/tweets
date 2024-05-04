package com.techuntried.jetpackcomposemvvm.navigation

sealed class Screens(val route: String) {
    object CategoryScreen : Screens("category")

    object TweetsScreen : Screens("tweets/{category}"){
        fun passCategory(category: String):String {
            return "tweets/$category"
        }
    }
    object SettingsScreen : Screens("settings?name={name}"){
        fun passName(name:String="achint"):String{
            return "settings?name=$name"
        }
    }
}
