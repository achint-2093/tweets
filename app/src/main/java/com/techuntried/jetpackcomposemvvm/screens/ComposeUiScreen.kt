package com.techuntried.jetpackcomposemvvm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.techuntried.jetpackcomposemvvm.R
import com.techuntried.jetpackcomposemvvm.navigation.Graphs
import com.techuntried.jetpackcomposemvvm.navigation.ComposeUiScreens
import com.techuntried.jetpackcomposemvvm.navigation.Screens

@Composable
fun ComposeUiScreen(navController: NavController) {
    val components = getComponents()
    val colors = listOf(Color.White, Color.Black, Color.Black, Color.White)

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(components.size) { index ->
            val component = components[index]
            val color = colors[index % colors.size]
            ComponentItem(name = component, color = color, navController = navController)
        }
    }
}

@Composable
fun ComponentItem(name: Components, color: Color, navController: NavController) {
    Box(
        modifier = Modifier
            .size(140.dp)
            .padding(8.dp)
            .clickable {
                when (name) {
                    Components.CustomUiComponent -> {
                        navController.navigate(ComposeUiScreens.CanvasScreen.route)
                    }

                    Components.Coil -> {
                        navController.navigate(ComposeUiScreens.CoilScreen.route)
                    }

                    Components.ImagePicker -> {
                        navController.navigate(ComposeUiScreens.ImagePickerScreen.route)
                    }

                    Components.BottomSheet -> TODO()
                    Components.AlertDialogs -> navController.navigate(ComposeUiScreens.AlertDialogScreen.route)
                    Components.FloatingButton -> navController.navigate(ComposeUiScreens.FloatingScreen.route)
                    Components.BottomNavbar -> navController.navigate(Graphs.BottomBarGraph)
                    Components.Drawer -> TODO()
                }
            }
            .clip(RoundedCornerShape(12.dp))
            .background(color = color),
        contentAlignment = Alignment.Center
    ) {
        val clr = if (color == Color.White)
            Color.Black
        else
            Color.White
        Text(
            text = name.toString(),
            color = clr,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

fun getComponents(): List<Components> {
    return enumValues<Components>().toMutableList()
}

enum class Components {
    CustomUiComponent,
    Coil,
    ImagePicker,
    BottomSheet,
    AlertDialogs,
    FloatingButton,
    BottomNavbar,
    Drawer
}

