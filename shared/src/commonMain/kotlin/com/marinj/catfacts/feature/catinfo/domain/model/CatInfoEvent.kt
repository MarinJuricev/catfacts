package com.marinj.catfacts.feature.catinfo.domain.model

sealed class CatInfoEvent {
    object GetCatInfo: CatInfoEvent()
}
