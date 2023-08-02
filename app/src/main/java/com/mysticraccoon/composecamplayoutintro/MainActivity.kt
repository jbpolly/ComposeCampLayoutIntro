package com.mysticraccoon.composecamplayoutintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mysticraccoon.composecamplayoutintro.ui.theme.ComposeCampLayoutIntroTheme
import com.mysticraccoon.composecamplayoutintro.ui.welcomePage.WelcomePage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCampLayoutIntroTheme {
              WelcomePage()
            }
        }
    }
}




