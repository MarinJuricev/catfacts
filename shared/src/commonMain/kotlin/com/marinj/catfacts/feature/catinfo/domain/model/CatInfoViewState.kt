package com.marinj.catfacts.feature.catinfo.domain.model

data class CatInfoViewState(
    val errorMessage: String? = null,
    val catInfo: String? = null,
    val isLoading: Boolean = false,
) {

    constructor() : this(
        errorMessage = null,
        catInfo = null,
        isLoading = false,
    )
}

