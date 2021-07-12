package com.marinj.catfacts.feature.catinfo.domain.usecase

import com.marinj.catfacts.core.Either
import com.marinj.catfacts.core.Failure
import com.marinj.catfacts.feature.catinfo.domain.model.CatInfo
import com.marinj.catfacts.feature.catinfo.domain.repository.CatInfoRepository

class GetRandomCatInfo(
    private val catInfoRepository: CatInfoRepository
) {

    suspend fun execute(): Either<Failure, CatInfo> =
        catInfoRepository.getRandomCatInfo()
}