@file:OptIn(ExperimentalFoundationApi::class)

package com.mysticraccoon.composecamplayoutintro.ui.welcomePage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mysticraccoon.composecamplayoutintro.data.WelcomePagerData
import com.mysticraccoon.composecamplayoutintro.data.getPagerData
import com.mysticraccoon.composecamplayoutintro.ui.theme.ComposeCampLayoutIntroTheme
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationDisabled
import com.mysticraccoon.composecamplayoutintro.ui.theme.MeditationGreen

@Composable
fun WelcomePage(modifier: Modifier = Modifier, onStartClicked: () -> Unit = {}) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
    ) {
        Column(
            modifier = Modifier
                .weight(weight = .2f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = buildAnnotatedString {
                    append("Focus, Relax\n")
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        append(" & ")
                    }
                    append("Sleep")
                },
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 42.sp,
            )
        }
//        Image(
//            painter = painterResource(id = R.drawable.tutorial_background),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(weight = .6f, fill = true)
//        )

        WelcomePagerComponent(
            pagerDataList = getPagerData(),
            modifier = Modifier.weight(weight = .6f, fill = true)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 16.dp)
                .weight(weight = .2f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = { },
                modifier = Modifier.widthIn(min = 100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.onBackground
                )
            ) {
                Text(text = "Skip")
            }
            Button(
                onClick = {
                    onStartClicked()
                },
                modifier = Modifier.widthIn(min = 100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    contentColor = MaterialTheme.colorScheme.background
                )
            ) {
                Text(text = "Let's Start")
            }
        }

    }
}

@Preview
@Composable
fun WelcomePagePreview() {
    ComposeCampLayoutIntroTheme {
        WelcomePage()
    }
}

@Composable
fun WelcomePagerComponent(
    pagerDataList: List<WelcomePagerData>, modifier: Modifier
) {
    if (pagerDataList.isEmpty()) return

    val state = rememberPagerState(initialPage = 0)
    val numLoops = Integer.MAX_VALUE / pagerDataList.size

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        HorizontalPager(
            pageCount = if (pagerDataList.size > 1) Integer.MAX_VALUE else pagerDataList.size,
            state = state,
            modifier = Modifier.weight(1f, fill = true)
        ) { pagerIndex ->
            val index = pagerIndex % pagerDataList.size
            pagerDataList.getOrNull(index)?.let {
                Image(
                    painter = painterResource(id = it.pagerData),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        if (pagerDataList.size > 1) {
            LineIndicator(
                totalLinesCount = pagerDataList.size,
                selectedIndex = state.currentPage % pagerDataList.size,
                selectedColor = MeditationGreen,
                unSelectedColor = MeditationDisabled,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }


    }

}

@Composable
fun LineIndicator(
    totalLinesCount: Int,
    selectedIndex: Int,
    selectedColor: Color,
    unSelectedColor: Color,
    modifier: Modifier = Modifier
) {

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(totalLinesCount) { index ->
            val backgroundColor = if (index == selectedIndex) selectedColor else unSelectedColor
            Box(
                modifier = Modifier
                    .height(5.dp)
                    .width(32.dp)
                    .clip(CircleShape)
                    .background(backgroundColor)
            )
        }
    }

}
