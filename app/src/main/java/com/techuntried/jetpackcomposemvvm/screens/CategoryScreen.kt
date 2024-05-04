package com.techuntried.jetpackcomposemvvm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.techuntried.jetpackcomposemvvm.R
import com.techuntried.jetpackcomposemvvm.navigation.Screens
import com.techuntried.jetpackcomposemvvm.viewmodel.CategoryViewModel

@Composable
fun CategoryScreen(navController: NavController) {
    val viewModel: CategoryViewModel = hiltViewModel()
    val categories = viewModel.categories.collectAsState()

    if (categories.value.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Loading..."
            )
        }
    } else {
        Column(horizontalAlignment = Alignment.End) {
            Button(onClick = {}, modifier = Modifier.padding(16.dp)) {
                Text(
                    modifier = Modifier.clickable { navController.navigate(Screens.SettingsScreen.passName("saksham")) },
                    text = "Settings"
                )
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                items(categories.value) {
                    CategoryItem(category = it, navController = navController)
                }
            }
        }

    }

}

@Composable
fun CategoryItem(category: String, navController: NavController) {
    Box(
        modifier = Modifier
            .size(140.dp)
            .padding(8.dp)
            .clickable { navController.navigate(Screens.TweetsScreen.passCategory(category)) }
            .clip(RoundedCornerShape(12.dp))
            .paint(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(text = category)
    }
}