package com.mysticraccoon.composecamplayoutintro.ui.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mysticraccoon.composecamplayoutintro.data.FeaturedData
import com.mysticraccoon.composecamplayoutintro.data.MostPlayed
import com.mysticraccoon.composecamplayoutintro.data.getFeaturedData
import com.mysticraccoon.composecamplayoutintro.data.getMostPlayedData
import com.mysticraccoon.composecamplayoutintro.ui.theme.ComposeCampLayoutIntroTheme
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationChipGrey
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationDisabled
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationDisabledText
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationItemBackground
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationWhite50

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

@Composable
fun FeaturedItem(featuredData: FeaturedData, modifier: Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(featuredData.backgroundColor)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MeditationWhite50),
            contentAlignment = Alignment.Center
        ) {
            featuredData.icon()
        }
        Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
            Text(
                text = featuredData.title,
                color = MaterialTheme.colorScheme.background,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
            )
            Text(
                text = featuredData.category,
                color = MaterialTheme.colorScheme.background,
                fontSize = 16.sp,
                fontWeight = FontWeight.Thin,
            )
        }
        Text(
            text = "${featuredData.duration} min",
            color = MaterialTheme.colorScheme.background,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )

    }
}

@Preview
@Composable
fun FeaturedItemPreview() {
    ComposeCampLayoutIntroTheme {
        FeaturedItem(featuredData = getFeaturedData()[0], modifier = Modifier)
    }
}

@Composable
fun MostPlayingItem(mostPlayed: MostPlayed, modifier: Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
        .heightIn(min = 80.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(MeditationItemBackground)
        .padding(horizontal = 24.dp)
    ) {
        Box(
            modifier = Modifier
                .align(CenterVertically)
                .size(50.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(mostPlayed.backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            mostPlayed.icon()
        }
        Column(modifier = Modifier.heightIn(min = 90.dp).padding(horizontal = 16.dp).weight(1f), verticalArrangement = Arrangement.Center) {
            Text(
                modifier = Modifier,
                text = mostPlayed.title,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
            )
            Text(
                modifier = Modifier,
                text = mostPlayed.category,
                color = MeditationDisabled,
                fontSize = 16.sp,
                fontWeight = FontWeight.Thin,
            )
        }
        Column(modifier = Modifier.heightIn(min = 90.dp), verticalArrangement = Arrangement.Center){
            Text(
                modifier = Modifier,
                text = "${mostPlayed.duration} min",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }

}

@Preview
@Composable
fun MostPlayingItemPreview() {
    ComposeCampLayoutIntroTheme {
        MostPlayingItem(mostPlayed = getMostPlayedData()[0], modifier = Modifier)
    }
}