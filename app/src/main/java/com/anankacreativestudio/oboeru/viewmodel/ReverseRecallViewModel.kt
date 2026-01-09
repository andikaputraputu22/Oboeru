package com.anankacreativestudio.oboeru.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anankacreativestudio.oboeru.models.QuizItem
import com.anankacreativestudio.oboeru.repository.KanaRepository
import com.anankacreativestudio.oboeru.utils.KanaMode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ReverseRecallViewModel @Inject constructor(
    private val kanaRepository: KanaRepository
) : ViewModel() {

    private val refreshTrigger = MutableSharedFlow<Unit>(
        extraBufferCapacity = 1
    )

    private val _kanaMode = MutableStateFlow(KanaMode.HIRAGANA)
    val kanaMode = _kanaMode.asStateFlow()

    val quiz: StateFlow<QuizItem> =
        combine(
            refreshTrigger.onStart { emit(Unit) },
            kanaMode
        ) { _, mode ->
            generateRandomQuiz(mode)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = generateRandomQuiz(KanaMode.HIRAGANA)
        )

    private fun generateRandomQuiz(mode: KanaMode): QuizItem {
        val allKana = when (mode) {
            KanaMode.HIRAGANA -> kanaRepository.hiraganaList
            KanaMode.KATAKANA -> kanaRepository.katakanaList
            KanaMode.RANDOM -> kanaRepository.hiraganaList + kanaRepository.katakanaList
        }
        val questionKana = allKana.random()
        val wrongAnswers = allKana
            .map { it.kana }
            .distinct()
            .filter { it != questionKana.kana }
            .shuffled()
            .take(3)

        val choices = (wrongAnswers + questionKana.kana).shuffled()

        return QuizItem(
            question = questionKana.romaji,
            correctAnswer = questionKana.kana,
            reading = questionKana.kana,
            choices = choices
        )
    }

    fun nextQuiz() {
        refreshTrigger.tryEmit(Unit)
    }

    fun setKanaMode(mode: KanaMode) {
        _kanaMode.value = mode
        refreshTrigger.tryEmit(Unit)
    }
}