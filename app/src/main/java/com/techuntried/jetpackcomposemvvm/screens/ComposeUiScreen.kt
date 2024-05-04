package com.techuntried.jetpackcomposemvvm.screens

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.techuntried.jetpackcomposemvvm.R
import com.techuntried.jetpackcomposemvvm.navigation.Screens

@Composable
fun ComposeUiScreen(navController: NavController) {
    val components = getComponents()
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(components) {
            ComponentItem(name = it, navController = navController)
        }
    }
}

@Composable
fun ComponentItem(name: String, navController: NavController) {
    Box(
        modifier = Modifier
            .size(140.dp)
            .padding(8.dp)
            .clickable {
                if (name == "Custom ui component") {
                    navController.navigate(Screens.CanvasScreen.route)
                }
            }
            .clip(RoundedCornerShape(12.dp))
            .paint(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(text = name)
    }
}

fun getComponents(): List<String> {
    val components = mutableListOf<String>()
    components.add("Custom ui component")
    components.add("Text")
    components.add("Text")
    components.add("Text")
    components.add("Text")
    components.add("Text")
    components.add("Text")
    return components
}