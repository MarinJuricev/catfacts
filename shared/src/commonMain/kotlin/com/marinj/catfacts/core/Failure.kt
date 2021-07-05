package com.marinj.catfacts.core

sealed class Failure {
    data class Message(val errorMessage: String) : Failure()
    object General : Failure()
}
