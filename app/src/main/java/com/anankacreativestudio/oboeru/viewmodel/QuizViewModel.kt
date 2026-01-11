package com.anankacreativestudio.oboeru.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anankacreativestudio.oboeru.models.QuizItem
import com.anankacreativestudio.oboeru.repository.KanaRepository
import com.anankacreativestudio.oboeru.utils.SettingsPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val kanaRepository: KanaRepository,
    private val settingsPreferences: SettingsPreferences
) : ViewModel() {

    private val refreshTrigger = MutableSharedFlow<Unit>(
        extraBufferCapacity = 1
    )

    val soundEnabled = settingsPreferences.soundEnabled
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            true
        )

    val quiz: StateFlow<QuizItem> =
        refreshTrigger
            .onStart { emit(Unit) }
            .map {
                generateRandomQuiz()
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = generateRandomQuiz()
            )

    private fun generateRandomQuiz(): QuizItem {
        val allKana = kanaRepository.hiraganaList + kanaRepository.katakanaList
        val questionKana = allKana.random()
        val wrongAnswers = allKana
            .map { it.romaji }
            .distinct()
            .filter { it != questionKana.romaji }
            .shuffled()
            .take(3)

        val choices = (wrongAnswers + questionKana.romaji).shuffled()

        return QuizItem(
            question = questionKana.kana,
            correctAnswer = questionKana.romaji,
            reading = questionKana.romaji,
            choices = choices
        )
    }

    fun nextQuiz() {
        refreshTrigger.tryEmit(Unit)
    }
}