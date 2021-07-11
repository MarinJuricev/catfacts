package com.marinj.catfacts.android.feature.catinfo.viewmodel

import androidx.lifecycle.viewModelScope
import com.marinj.catfacts.android.core.base.BaseViewModel
import com.marinj.catfacts.android.feature.catinfo.CatInfoEvent
import com.marinj.catfacts.android.feature.catinfo.model.CatInfoViewState
import com.marinj.catfacts.core.Either
import com.marinj.catfacts.core.mapper.FailureToErrorMessageMapper
import com.marinj.catfacts.feature.catinfo.domain.usecase.GetRandomCatInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CatInfoViewModel(
    private val getRandomCatInfo: GetRandomCatInfo,
    private val failureToErrorMessageMapper: FailureToErrorMessageMapper,
) : BaseViewModel<CatInfoEvent>() {

    private val _catInfoViewState = MutableStateFlow(CatInfoViewState())
    val catInfoViewState: StateFlow<CatInfoViewState> = _catInfoViewState

    override fun onEvent(event: CatInfoEvent) {
        when (event) {
            CatInfoEvent.GetCatInfo -> handleGetCatInfo()
        }
    }

    private fun handleGetCatInfo() = viewModelScope.launch {
        _catInfoViewState.emit(_catInfoViewState.value.copy(isLoading = true))
        delay(200)

        when (val result = getRandomCatInfo()) {
            is Either.Right -> _catInfoViewState.emit(
                catInfoViewState.value.copy(
                    catInfo = result.value.information,
                    errorMessage = null,
                    isLoading = false,
                )
            )
            is Either.Left -> _catInfoViewState.emit(
                catInfoViewState.value.copy(
                    catInfo = null,
                    errorMessage = failureToErrorMessageMapper.map(result.error),
                    isLoading = false,
                )
            )
        }
    }
}