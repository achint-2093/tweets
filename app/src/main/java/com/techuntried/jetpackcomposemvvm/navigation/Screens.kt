package com.techuntried.jetpackcomposemvvm.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route: String) {
    object CategoryScreen : Screens("category")

    object TweetsScreen : Screens("tweets/{category}"){
        fun passCategory(category: String):String {
            return "tweets/$category"
        }
    }
}

sealed class ComposeUiScreens(val route: String){

    object ComposeUiScreen : ComposeUiScreens("compose?name={name}"){
        fun passName(name:String="achint"):String{
            return "compose?name=$name"
        }
    }
    object CanvasScreen:ComposeUiScreens("canvas")

    object CoilScreen:ComposeUiScreens("coil")
    object ImagePickerScreen:ComposeUiScreens("image_picker")
    object AlertDialogScreen:ComposeUiScreens("alert")
    object FloatingScreen:ComposeUiScreens("floating")
}

sealed class BottomBarScreens(val route: String, val title: String, val icon: ImageVector) {
    object HomeScreen : BottomBarScreens("home","Home", Icons.Filled.Home)
    object ProfileScreen : BottomBarScreens("profile","Profile", Icons.Filled.Person)
    object SearchScreen : BottomBarScreens("search","Search", Icons.Filled.Search)
}
