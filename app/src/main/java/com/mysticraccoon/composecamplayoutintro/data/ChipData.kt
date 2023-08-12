package com.mysticraccoon.composecamplayoutintro.data

data class ChipData(val text: String, var isSelected: Boolean)

fun getChipData() = listOf<ChipData>(
    ChipData("Healing Music", true),
    ChipData("Sounds", false),
    ChipData("Sleep meditation", false),
    ChipData("White noise", false)
)