package com.mysticraccoon.composecamplayoutintro.ui.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mysticraccoon.composecamplayoutintro.data.ChipData
import com.mysticraccoon.composecamplayoutintro.data.getChipData
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
    ){
        items(list){ chipData ->
            HomePageChip(text = chipData.text, isSelect = chipData.isSelected)
        }
    }
}