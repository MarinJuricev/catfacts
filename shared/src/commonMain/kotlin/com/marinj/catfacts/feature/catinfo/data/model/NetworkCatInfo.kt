package com.marinj.catfacts.feature.catinfo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkCatInfo(
    val fact: String,
    val length: Int,
)
