package com.mysticraccoon.composecamplayoutintro.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationGreen
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationPink
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationPurple

data class MostPlayed(
    val title: String,
    val category: String,
    val duration: Int,
    val backgroundColor: Color,
    val icon: @Composable () -> Unit
)

fun getMostPlayedData() = listOf<MostPlayed>(

    MostPlayed(
        title = "Deep Sleep",
        category = "Music",
        duration = 32,
        backgroundColor = MeditationGreen,
        icon = {
            Icon(imageVector = Icons.Filled.DarkMode, contentDescription = "Deep Sleep")
        }
    ),
    MostPlayed(
        title = "Self Healing",
        category = "Story",
        duration = 46,
        backgroundColor = MeditationPurple,
        icon = {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Self Healing")
        }
    ),
    MostPlayed(
        title = "Guided Relaxation",
        category = "Story",
        duration = 25,
        backgroundColor = MeditationPink,
        icon = {
            Icon(imageVector = Icons.Filled.Spa, contentDescription = "Guided Relaxation")
        }
    ),
    MostPlayed(
        title = "Meditation",
        category = "Music",
        duration = 30,
        backgroundColor = MeditationGreen,
        icon = {
            Icon(imageVector = Icons.Filled.MusicNote, contentDescription = "Meditation")
        }
    ),
    MostPlayed(
        title = "Sounds of the Wind",
        category = "Music",
        duration = 30,
        backgroundColor = MeditationGreen,
        icon = {
            Icon(imageVector = Icons.Filled.Air, contentDescription = "Sounds of the Wind")
        }
    ),

)