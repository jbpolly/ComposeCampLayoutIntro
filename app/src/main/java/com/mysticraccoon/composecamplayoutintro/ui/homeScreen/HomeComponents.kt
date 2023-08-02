package com.mysticraccoon.composecamplayoutintro.ui.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mysticraccoon.composecamplayoutintro.ui.theme.ComposeCampLayoutIntroTheme
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationChipGrey
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationDisabled
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationItemBackground

@Composable
fun HomeHeader() {
    Row(
        modifier = Modifier
            .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 0.dp)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = buildAnnotatedString {
                append("Hello, ")
                withStyle(
                    style =
                    SpanStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold)
                ) {
                    append("Juliana")
                }
            },
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 24.sp,
            fontWeight = FontWeight.Thin
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(
                    MeditationItemBackground
                )
                .size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notifications",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun HomePageChip(text: String, isSelect: Boolean) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(color = if (isSelect) MeditationChipGrey else MeditationItemBackground)
    ) {
        Text(
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 10.dp),
            text = text,
            color = if (isSelect) MaterialTheme.colorScheme.onBackground else MeditationDisabled,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview
@Composable
fun HomePageChipPreviewSelected() {
    ComposeCampLayoutIntroTheme {
        HomePageChip(text = "Healing Music", isSelect = true)
    }
}

@Preview
@Composable
fun HomePageChipPreviewNotSelected() {
    ComposeCampLayoutIntroTheme {
        HomePageChip(text = "Sounds", isSelect = false)
    }
}