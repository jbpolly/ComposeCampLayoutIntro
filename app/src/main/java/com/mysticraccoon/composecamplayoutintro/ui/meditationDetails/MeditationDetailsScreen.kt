package com.mysticraccoon.composecamplayoutintro.ui.meditationDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mysticraccoon.composecamplayoutintro.ui.theme.ComposeCampLayoutIntroTheme

@Composable
fun MeditationDetailsScreen(textToPresent: String = "") {
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background), contentAlignment = Alignment.Center){
        Text(
            text = "Hello $textToPresent",
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview
@Composable
fun MeditationDetailsScreenPreview() {
    ComposeCampLayoutIntroTheme {
        MeditationDetailsScreen()
    }
}