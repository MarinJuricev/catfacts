package com.marinj.catfacts.di

import com.marinj.catfacts.core.mapper.FailureToErrorMessageMapper
import org.koin.dsl.module

val commonCoreModule = module {
    factory { FailureToErrorMessageMapper() }
}