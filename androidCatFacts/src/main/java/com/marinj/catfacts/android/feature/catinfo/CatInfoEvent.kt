package com.marinj.catfacts.android.feature.catinfo

sealed class CatInfoEvent {
    object GetCatInfo: CatInfoEvent()
}
