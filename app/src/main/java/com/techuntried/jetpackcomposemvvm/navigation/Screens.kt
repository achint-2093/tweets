package com.techuntried.jetpackcomposemvvm.navigation

sealed class Screens(val route: String) {
    object CategoryScreen : Screens("category")

    object TweetsScreen : Screens("tweets/{category}"){
        fun passCategory(category: String):String {
            return "tweets/$category"
        }
    }
    object ComposeUiScreen : Screens("compose?name={name}"){
        fun passName(name:String="achint"):String{
            return "compose?name=$name"
        }
    }

    object CanvasScreen:Screens("canvas")

    object CoilScreen:Screens("coil")
    object ImagePickerScreen:Screens("image_picker")
    object AlertDialogScreen:Screens("alert")
    object FloatingScreen:Screens("floating")
    object BottomNavScreen:Screens("bottomNav")
}
