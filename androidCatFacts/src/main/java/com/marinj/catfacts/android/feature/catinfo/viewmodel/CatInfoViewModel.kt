package com.marinj.catfacts.android.feature.catinfo.viewmodel

import androidx.lifecycle.viewModelScope
import com.marinj.catfacts.android.core.base.BaseViewModel
import com.marinj.catfacts.android.feature.catinfo.CatInfoEvent
import com.marinj.catfacts.feature.catinfo.domain.usecase.GetRandomCatInfo
import kotlinx.coroutines.launch

class CatInfoViewModel(
    private val getRandomCatInfo: GetRandomCatInfo
) : BaseViewModel<CatInfoEvent>() {

    override fun onEvent(event: CatInfoEvent) {
        when (event) {
            CatInfoEvent.GetCatInfo -> handleGetCatInfo()
        }
    }

    private fun handleGetCatInfo() = viewModelScope.launch {
            }
}