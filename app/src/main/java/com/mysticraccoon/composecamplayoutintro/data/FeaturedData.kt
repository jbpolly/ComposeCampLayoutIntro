package com.mysticraccoon.composecamplayoutintro.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationGreen
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationPurple

data class FeaturedData(
    val title: String,
    val category: String,
    val duration: Int,
    val backgroundColor: Color,
    val icon: @Composable () -> Unit
    )

fun getFeaturedData(): List<FeaturedData>{
    return listOf(
        FeaturedData(
            title = "Best Insomnia",
            category = "Story",
            duration = 32,
            backgroundColor = MeditationPurple,
            icon = {
                Icon(imageVector = Icons.Filled.Cloud, contentDescription = "Best Insomnia")
            }
        ),
        FeaturedData(
            title = "Sleep at Easy",
            category = "Music",
            duration = 54,
            backgroundColor = MeditationGreen,
            icon = {
                Icon(imageVector = Icons.Filled.Star, contentDescription = null)
            }
        ),
        FeaturedData(
            title = "Tales of Night",
            category = "Story",
            duration = 45,
            backgroundColor = MeditationPurple,
            icon = {
                Icon(imageVector = Icons.Filled.MenuBook, contentDescription = null)
            }
        ),
    )
}
