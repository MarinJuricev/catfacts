package com.marinj.catfacts.di

import com.marinj.catfacts.feature.catinfo.di.commonCatInfoModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            commonCoreModule,
            commonCatInfoModule,
        )
    }

// called by iOS etc
fun initKoin() = initKoin {}