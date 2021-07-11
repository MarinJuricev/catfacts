package com.marinj.catfacts.feature.catinfo.di

import com.marinj.catfacts.core.KtorClientFactory
import com.marinj.catfacts.feature.catinfo.data.api.CatInfoApiService
import com.marinj.catfacts.feature.catinfo.data.api.CatInfoApiServiceImpl
import com.marinj.catfacts.feature.catinfo.data.mapper.NetworkToDomainCatInfoMapper
import com.marinj.catfacts.feature.catinfo.data.repository.CatInfoRepositoryImpl
import com.marinj.catfacts.feature.catinfo.domain.repository.CatInfoRepository
import com.marinj.catfacts.feature.catinfo.domain.usecase.GetRandomCatInfo
import org.koin.dsl.module

private const val CAT_INFO_ENDPOINT = "https://catfact.ninja"

val commonCatInfoModule = module {
    single { KtorClientFactory().build() }

    factory<CatInfoApiService> { CatInfoApiServiceImpl(get(), CAT_INFO_ENDPOINT) }
    factory { NetworkToDomainCatInfoMapper() }
    factory<CatInfoRepository> { CatInfoRepositoryImpl(get(), get()) }
    factory { GetRandomCatInfo(get()) }
}