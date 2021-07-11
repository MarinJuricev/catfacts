package com.marinj.catfacts.feature.catinfo.data.repository

import com.marinj.catfacts.core.Either
import com.marinj.catfacts.core.Failure
import com.marinj.catfacts.core.buildRight
import com.marinj.catfacts.feature.catinfo.data.api.CatInfoApiService
import com.marinj.catfacts.feature.catinfo.data.mapper.NetworkToDomainCatInfoMapper
import com.marinj.catfacts.feature.catinfo.domain.model.CatInfo
import com.marinj.catfacts.feature.catinfo.domain.repository.CatInfoRepository

class CatInfoRepositoryImpl(
    private val catInfoApiService: CatInfoApiService,
    private val networkToDomainCatInfoMapper: NetworkToDomainCatInfoMapper,
) : CatInfoRepository {

    override suspend fun getRandomCatInfo(): Either<Failure, CatInfo> =
        when (val result = catInfoApiService.getRandomCatInfo()) {
            is Either.Right -> networkToDomainCatInfoMapper.map(result.value).buildRight()
            is Either.Left -> result
        }
}