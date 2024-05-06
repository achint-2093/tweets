package com.techuntried.jetpackcomposemvvm.screens.composeui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.techuntried.jetpackcomposemvvm.R

@Composable
fun CoilScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val list = getImageList()
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(list) {
                CoilItem(imageUrl = it)
            }
        }
    }

}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CoilItem(imageUrl: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Black.copy(alpha = 0.1f)),
        contentAlignment = Alignment.Center
    ) {
        val paint = rememberImagePainter(data = imageUrl, builder = {
            placeholder(R.drawable.ic_launcher_background)
            crossfade(5000)
        })
        Image(painter = paint, contentDescription = "")
    }
}

fun getImageList(): List<String> {
    val images = mutableListOf<String>()
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    images.add("https://i.pinimg.com/564x/51/1e/29/511e293a6240ea961a0c4a12c697ffab.jpg")
    return images

}