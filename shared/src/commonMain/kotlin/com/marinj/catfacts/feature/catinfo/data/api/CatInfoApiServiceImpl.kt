package com.marinj.catfacts.feature.catinfo.data.api

import com.marinj.catfacts.core.Either
import com.marinj.catfacts.core.Failure
import com.marinj.catfacts.core.buildLeft
import com.marinj.catfacts.core.buildRight
import com.marinj.catfacts.feature.catinfo.data.model.NetworkCatInfo
import io.ktor.client.*
import io.ktor.client.request.*

class CatInfoApiServiceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String, // https://catfact.ninja
) : CatInfoApiService {

    override suspend fun getRandomCatInfo(): Either<Failure, NetworkCatInfo> {
        return try {
            httpClient.get<NetworkCatInfo> {
                url("$baseUrl/fact")
            }.buildRight()
        } catch (throwable: Throwable) {
            if (throwable.message.isNullOrBlank()) {
                Failure.General.buildLeft()
            } else
                Failure.Message(throwable.message!!).buildLeft()
        }
    }
}