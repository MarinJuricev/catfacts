package com.marinj.catfacts.android.feature.catinfo.model

data class CatInfoViewState(
    val errorMessage: String? = null,
    val catInfo: String? = null,
    val isLoading: Boolean = false,
)
