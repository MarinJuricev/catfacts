package com.marinj.catfacts.feature.catinfo.data.api

import com.marinj.catfacts.core.Either
import com.marinj.catfacts.core.Failure
import com.marinj.catfacts.feature.catinfo.data.model.NetworkCatInfo

interface CatInfoApiService {
    suspend fun getRandomCatInfo(): Either<Failure, NetworkCatInfo>
}