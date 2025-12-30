package com.anankacreativestudio.oboeru

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.anankacreativestudio.oboeru.notification.NotificationUtil
import com.anankacreativestudio.oboeru.ui.theme.OboeruTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var notificationUtil: NotificationUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        notificationUtil.createChannel()

        val openQuizFromNotification =
            intent.getBooleanExtra("OPEN_QUIZ", false)

        setContent {
            OboeruTheme {
                OboeruApp(
                    openQuizFromNotification = openQuizFromNotification
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Oboeru!",
            fontSize = 38.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "おぼえる",
            fontSize = 22.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OboeruTheme {
        Greeting("Android")
    }
}