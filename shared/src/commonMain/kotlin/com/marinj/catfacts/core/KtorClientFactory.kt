package com.marinj.catfacts.core

import io.ktor.client.*

expect class KtorClientFactory() {
    fun build(): HttpClient
}