package com.marinj.catfacts.feature.catinfo.domain.repository

import com.marinj.catfacts.core.Either
import com.marinj.catfacts.core.Failure
import com.marinj.catfacts.feature.catinfo.domain.model.CatInfo

interface CatInfoRepository {
    suspend fun getRandomCatInfo(): Either<Failure, CatInfo>
}