package com.anankacreativestudio.oboeru.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.anankacreativestudio.oboeru.ui.component.ConfettiEffect
import com.anankacreativestudio.oboeru.ui.component.HeaderPageWithBack
import com.anankacreativestudio.oboeru.ui.component.NextQuestionButton
import com.anankacreativestudio.oboeru.ui.component.QuizChoiceItem
import com.anankacreativestudio.oboeru.viewmodel.KanaRecallViewModel
import kotlinx.coroutines.delay

@Composable
fun KanaRecallScreen(
    onBackClick: () -> Unit = {}
) {
    val viewModel: KanaRecallViewModel = hiltViewModel()
    val colors = MaterialTheme.colorScheme
    val haptic = LocalHapticFeedback.current

    val quiz by viewModel.quiz.collectAsStateWithLifecycle()

    var isNextEnabled by remember { mutableStateOf(true) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var isCorrect by remember { mutableStateOf<Boolean?>(null) }
    var showConfetti by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isCorrect == true) 1.1f else 1f,
        label = "scale"
    )

    LaunchedEffect(showConfetti) {
        if (showConfetti) {
            delay(900)
            showConfetti = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .imePadding(),
            topBar = {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 48.dp, start = 16.dp, end = 16.dp),
                    color = colors.background
                ) {
                    HeaderPageWithBack(
                        title = "Quiz",
                        imageVector = Icons.Default.Close,
                        onBackClick = onBackClick
                    )
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = quiz.question,
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.scale(scale)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "What is the reading of this letter?",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(24.dp))
                quiz.choices.forEach { choice ->
                    val isSelected = selectedAnswer == choice
                    val backgroundColor = when {
                        isCorrect == null -> colors.surfaceVariant
                        choice == quiz.correctAnswer -> Color(0xFFB7EFC5)
                        isSelected -> Color(0xFFFFC9C9)
                        else -> colors.surfaceVariant
                    }

                    val textColor = when {
                        selectedAnswer == null -> colors.onSurface
                        choice == quiz.correctAnswer -> Color.Black
                        choice == selectedAnswer -> Color.Black
                        else -> colors.onSurfaceVariant
                    }

                    QuizChoiceItem(
                        text = choice,
                        enabled = selectedAnswer == null,
                        backgroundColor = backgroundColor,
                        textColor = textColor,
                        isSelected = isSelected,
                        isCorrectAnswer = choice == quiz.correctAnswer,
                        showResult = selectedAnswer != null,
                        onClick = {
                            selectedAnswer = choice
                            val correct = choice == quiz.correctAnswer
                            isCorrect = correct

                            if (correct) {
                                showConfetti = true
                            }

                            haptic.performHapticFeedback(
                                if (correct) {
                                    HapticFeedbackType.LongPress
                                } else {
                                    HapticFeedbackType.TextHandleMove
                                }
                            )
                        }
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                AnimatedVisibility(visible = isCorrect != null) {
                    Text(
                        text = if (isCorrect == true) {
                            "✔ Correct! (${quiz.reading})"
                        } else {
                            "✖ Wrong, the answer is ${quiz.correctAnswer}"
                        },
                        color = if (isCorrect == true) {
                            Color(0xFF2E7D32)
                        } else {
                            Color.Red
                        },
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                NextQuestionButton(
                    enabled = selectedAnswer != null && isNextEnabled,
                    onClick = {
                        isNextEnabled = false
                        selectedAnswer = null
                        isCorrect = null
                        showConfetti = false

                        viewModel.nextQuiz()
                        isNextEnabled = true
                    }
                )
            }
        }

        ConfettiEffect(
            trigger = showConfetti,
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1f)
        )
    }
}