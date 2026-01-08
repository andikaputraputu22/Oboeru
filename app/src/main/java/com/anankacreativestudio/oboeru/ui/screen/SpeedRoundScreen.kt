package com.anankacreativestudio.oboeru.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.anankacreativestudio.oboeru.ui.component.ChoiceButton
import com.anankacreativestudio.oboeru.ui.component.HeaderPageWithBack
import com.anankacreativestudio.oboeru.ui.component.QuestionCard
import com.anankacreativestudio.oboeru.ui.component.SpeedRoundHeader
import com.anankacreativestudio.oboeru.ui.component.SpeedRoundReady
import com.anankacreativestudio.oboeru.ui.component.SpeedRoundResult
import com.anankacreativestudio.oboeru.utils.SpeedRoundEvent
import com.anankacreativestudio.oboeru.utils.SpeedRoundState
import com.anankacreativestudio.oboeru.viewmodel.SpeedRoundViewModel
import kotlinx.coroutines.delay

@Composable
fun SpeedRoundScreen(
    onBackClick: () -> Unit = {}
) {
    val viewModel: SpeedRoundViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val highScore by viewModel.highScore.collectAsStateWithLifecycle()
    val colors = MaterialTheme.colorScheme
    val haptic = LocalHapticFeedback.current

    LaunchedEffect(state) {
        if (state is SpeedRoundState.Playing) {
            delay(1_000)
            viewModel.onEvent(SpeedRoundEvent.Tick)
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .imePadding(),
        topBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp, bottom = 24.dp, start = 16.dp, end = 16.dp),
                color = colors.background
            ) {
                HeaderPageWithBack(
                    title = "Speed Round",
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    onBackClick = onBackClick
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (state) {
                SpeedRoundState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                SpeedRoundState.Ready -> {
                    SpeedRoundReady(
                        highScore = highScore,
                        onStartClick = {
                            viewModel.onEvent(SpeedRoundEvent.Start)
                        }
                    )
                }
                is SpeedRoundState.Playing -> {
                    val s = state as SpeedRoundState.Playing
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SpeedRoundHeader(
                            remainingTime = s.remainingTime,
                            progress = s.remainingTime / 60f
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        QuestionCard(
                            question = s.quiz.question
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Column(
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            s.quiz.choices.forEach { choice ->
                                ChoiceButton(
                                    text = choice,
                                    onClick = {
                                        viewModel.onEvent(
                                            SpeedRoundEvent.SelectAnswer(choice)
                                        )
                                        haptic.performHapticFeedback(
                                            HapticFeedbackType.TextHandleMove
                                        )
                                    }
                                )
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "Score: ${s.score}",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = colors.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
                is SpeedRoundState.Finished -> {
                    val s = state as SpeedRoundState.Finished
                    SpeedRoundResult(
                        score = s.score,
                        onRetry = {
                            viewModel.onEvent(SpeedRoundEvent.Start)
                        },
                        onFinish = onBackClick
                    )
                }
            }
        }
    }
}