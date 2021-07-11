package com.marinj.catfacts.android.feature.catinfo.di

import com.marinj.catfacts.android.feature.catinfo.viewmodel.CatInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val catInfoModule = module {
    viewModel { CatInfoViewModel(get(), get()) }
}