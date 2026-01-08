package com.anankacreativestudio.oboeru.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anankacreativestudio.oboeru.models.QuizItem
import com.anankacreativestudio.oboeru.repository.KanaRepository
import com.anankacreativestudio.oboeru.utils.GamePreferences
import com.anankacreativestudio.oboeru.utils.SpeedRoundEvent
import com.anankacreativestudio.oboeru.utils.SpeedRoundState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpeedRoundViewModel @Inject constructor(
    private val kanaRepository: KanaRepository,
    private val gamePreferences: GamePreferences
) : ViewModel() {

    private val totalTime = 60

    private val _state =
        MutableStateFlow<SpeedRoundState>(SpeedRoundState.Loading)
    val state = _state.asStateFlow()

    val highScore = gamePreferences.speedRoundHighScore
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            0
        )

    init {
        _state.value = SpeedRoundState.Ready
    }

    fun onEvent(event: SpeedRoundEvent) {
        when (val s = _state.value) {
            SpeedRoundState.Loading -> Unit
            SpeedRoundState.Ready -> {
                if (event is SpeedRoundEvent.Start) {
                    startNewGame()
                }
            }
            is SpeedRoundState.Playing -> {
                when (event) {
                    is SpeedRoundEvent.SelectAnswer -> {
                        val correct = event.answer == s.quiz.correctAnswer
                        _state.value = s.copy(
                            quiz = generateRandomQuiz(),
                            score = if (correct) s.score + 1 else s.score
                        )
                    }
                    SpeedRoundEvent.Tick -> {
                        if (s.remainingTime <= 1) {
                            viewModelScope.launch {
                                gamePreferences.updateHighScoreIfNeeded(s.score)
                            }
                            _state.value = SpeedRoundState.Finished(
                                score = s.score
                            )
                        } else {
                            _state.value = s.copy(
                                remainingTime = s.remainingTime - 1
                            )
                        }
                    }
                    else -> Unit
                }
            }
            is SpeedRoundState.Finished -> {
                if (event is SpeedRoundEvent.Start) {
                    startNewGame()
                }
            }
        }
    }

    private fun startNewGame() {
        _state.value = SpeedRoundState.Playing(
            quiz = generateRandomQuiz(),
            remainingTime = totalTime,
            score = 0
        )
    }

    private fun generateRandomQuiz(): QuizItem {
        val allKana = kanaRepository.hiraganaList + kanaRepository.katakanaList
        val question = allKana.random()

        val choices = allKana
            .map { it.romaji }
            .distinct()
            .filter { it != question.romaji }
            .shuffled()
            .take(3)
            .plus(question.romaji)
            .shuffled()

        return QuizItem(
            question = question.kana,
            correctAnswer = question.romaji,
            choices = choices,
            reading = question.romaji
        )
    }
}