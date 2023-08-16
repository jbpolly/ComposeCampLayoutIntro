package com.mysticraccoon.composecamplayoutintro.data

import androidx.annotation.DrawableRes
import com.mysticraccoon.composecamplayoutintro.R

data class WelcomePagerData(
    @DrawableRes val pagerData: Int
)

fun getPagerData() = listOf<WelcomePagerData>(
    WelcomePagerData(pagerData = R.drawable.tutorial_background),
    WelcomePagerData(pagerData = R.drawable.tutorial2_background)
)
