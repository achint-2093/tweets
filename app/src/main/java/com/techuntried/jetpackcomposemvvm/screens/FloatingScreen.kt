package com.techuntried.jetpackcomposemvvm.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FloatingScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            text = "Nature, with its boundless beauty and intricacies, serves as a perennial source of wonder and inspiration. It encompasses a vast array of landscapes, each with its own unique charm and character. From the towering majesty of mountains, their peaks often shrouded in mist or snow, standing as silent sentinels against the sky, to the serene tranquility of tranquil lakes reflecting the azure heavens above, nature's allure knows no bounds.\n\n" +
                    "Every element of nature plays a vital role in the grand tapestry of life. The gentle rustle of leaves in the breeze whispers secrets of the forest, while the melodic chirping of birds heralds the arrival of a new day. Flowers bloom in a riot of colors, attracting bees and butterflies, ensuring the continuation of pollination and the cycle of growth.\n\n" +
                    "Yet, nature is not just about beauty and harmony; it is also a force to be reckoned with. The roar of thunder and the flash of lightning remind us of its raw power, while the raging seas and howling winds showcase its unforgiving side.\n\n" +
                    "Amidst this grandeur and unpredictability, there is a sense of peace and balance that pervades everything. It is a reminder of our place in the universe and the importance of cherishing and preserving the precious gift of nature for generations to come." +
                    "Nature, with its boundless beauty and intricacies, serves as a perennial source of wonder and inspiration. It encompasses a vast array of landscapes, each with its own unique charm and character. From the towering majesty of mountains, their peaks often shrouded in mist or snow, standing as silent sentinels against the sky, to the serene tranquility of tranquil lakes reflecting the azure heavens above, nature's allure knows no bounds.\n\n" +
                    "Every element of nature plays a vital role in the grand tapestry of life. The gentle rustle of leaves in the breeze whispers secrets of the forest, while the melodic chirping of birds heralds the arrival of a new day. Flowers bloom in a riot of colors, attracting bees and butterflies, ensuring the continuation of pollination and the cycle of growth.\n\n" +
                    "Yet, nature is not just about beauty and harmony; it is also a force to be reckoned with. The roar of thunder and the flash of lightning remind us of its raw power, while the raging seas and howling winds showcase its unforgiving side.\n\n" +
                    "Amidst this grandeur and unpredictability, there is a sense of peace and balance that pervades everything. It is a reminder of our place in the universe and the importance of cherishing and preserving the precious gift of nature for generations to come."

        )
        FloatingActionButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "")
        }

    }

}