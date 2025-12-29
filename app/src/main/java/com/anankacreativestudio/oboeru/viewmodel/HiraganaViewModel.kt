package com.anankacreativestudio.oboeru.viewmodel

import androidx.lifecycle.ViewModel
import com.anankacreativestudio.oboeru.models.Kana
import com.anankacreativestudio.oboeru.repository.KanaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HiraganaViewModel @Inject constructor(
    private val kanaRepository: KanaRepository
) : ViewModel() {

    val hiraganaList: List<Kana> = kanaRepository.hiraganaList
}