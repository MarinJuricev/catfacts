package com.marinj.catfacts

actual fun runBlocking(block: suspend () -> Unit) = kotlinx.coroutines.runBlocking { block() }