package com.anankacreativestudio.oboeru.viewmodel

import androidx.lifecycle.ViewModel
import com.anankacreativestudio.oboeru.models.PracticeMode
import com.anankacreativestudio.oboeru.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PracticeViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    val practiceModes: List<PracticeMode> = mainRepository.practiceModes
}