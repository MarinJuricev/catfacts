package com.marinj.catfacts.core.mapper

import com.marinj.catfacts.core.Failure

class FailureToErrorMessageMapper {

    fun map(failure: Failure): String {
        return when (failure) {
            is Failure.Message -> failure.errorMessage
            Failure.General -> "Unknown Error, please try again."
        }
    }
}