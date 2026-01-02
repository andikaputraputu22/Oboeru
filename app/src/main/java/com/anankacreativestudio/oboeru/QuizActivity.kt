package com.anankacreativestudio.oboeru

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.anankacreativestudio.oboeru.ui.screen.QuizScreen
import com.anankacreativestudio.oboeru.ui.theme.OboeruTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OboeruTheme {
                QuizScreen(
                    onBackClick = {
                        finish()
                    }
                )
            }
        }
    }
}