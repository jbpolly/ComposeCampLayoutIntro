package com.mysticraccoon.composecamplayoutintro.ui.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mysticraccoon.composecamplayoutintro.data.ChipData
import com.mysticraccoon.composecamplayoutintro.data.FeaturedData
import com.mysticraccoon.composecamplayoutintro.data.MostPlayed
import com.mysticraccoon.composecamplayoutintro.data.getChipData
import com.mysticraccoon.composecamplayoutintro.data.getFeaturedData
import com.mysticraccoon.composecamplayoutintro.data.getMostPlayedData
import com.mysticraccoon.composecamplayoutintro.ui.theme.ComposeCampLayoutIntroTheme

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HomeHeader()
        ChipList(getChipData())
        FeaturedSection(getFeaturedData())
        MostPlayingSection(mostPlayedData = getMostPlayedData())
    }

}

@Preview
@Composable
fun HomePagePreview() {
    ComposeCampLayoutIntroTheme {
        HomePage()
    }
}

@Composable
fun ChipList(list: List<ChipData>) {
    LazyRow(
        modifier = Modifier,
        contentPadding = PaddingValues(24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(list) { chipData ->
            HomePageChip(text = chipData.text, isSelect = chipData.isSelected)
        }
    }
}

@Composable
fun FeaturedSection(featuredData: List<FeaturedData>) {
    Column {
        Text(
            modifier = Modifier.padding(horizontal = 24.dp),
            text = "Featured",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        LazyRow(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(start = 4.dp, end = 4.dp)
        ) {
            items(featuredData.size) {
                FeaturedItem(featuredData[it], modifier = Modifier.fillParentMaxWidth(.48f))
            }
        }
    }
}

@Composable
fun MostPlayingSection(mostPlayedData: List<MostPlayed>) {
    Column {
        Row {
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .weight(1f),
                text = "Featured",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                text = "See all",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        LazyColumn(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(start = 4.dp, end = 4.dp)
        ) {
            items(mostPlayedData) {
                MostPlayingItem(it, modifier = Modifier)
            }
        }
    }
}