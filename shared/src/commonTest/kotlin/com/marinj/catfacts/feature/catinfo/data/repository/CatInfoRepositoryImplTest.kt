package com.marinj.catfacts.feature.catinfo.data.repository

import com.marinj.catfacts.core.Either
import com.marinj.catfacts.core.Failure
import com.marinj.catfacts.core.buildLeft
import com.marinj.catfacts.core.buildRight
import com.marinj.catfacts.feature.catinfo.data.api.CatInfoApiService
import com.marinj.catfacts.feature.catinfo.data.mapper.NetworkToDomainCatInfoMapper
import com.marinj.catfacts.feature.catinfo.data.model.NetworkCatInfo
import com.marinj.catfacts.feature.catinfo.domain.model.CatInfo
import com.marinj.catfacts.feature.catinfo.domain.repository.CatInfoRepository
import com.marinj.catfacts.runBlocking
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CatInfoRepositoryImplTest {

    private val catInfoApiService: CatInfoApiService = mockk()
    private val networkToDomainCatInfoMapper: NetworkToDomainCatInfoMapper = mockk()

    private lateinit var sut: CatInfoRepository

    @BeforeTest
    fun setUp() {
        sut = CatInfoRepositoryImpl(
            catInfoApiService,
            networkToDomainCatInfoMapper,
        )
    }

    @Test
    fun getRandomCatInfo_should_return_EitherRight_when_catInfoApiServiceReturnsRight() = runBlocking {
        val networkCatInfo = mockk<NetworkCatInfo>()
        val catInfo = mockk<CatInfo>()
        val apiServiceResult: Either<Failure, NetworkCatInfo> = networkCatInfo.buildRight()
        coEvery {
            catInfoApiService.getRandomCatInfo()
        } coAnswers { apiServiceResult }
        every {
            networkToDomainCatInfoMapper.map(networkCatInfo)
        } answers { catInfo }

        val actualResult = sut.getRandomCatInfo()
        val expectedResult = catInfo.buildRight()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun getRandomCatInfo_should_return_EitherLeft_when_catInfoApiServiceReturnsLeft() = runBlocking {
        val failure = mockk<Failure>()
        val apiServiceResult: Either<Failure, NetworkCatInfo> = failure.buildLeft()
        coEvery {
            catInfoApiService.getRandomCatInfo()
        } coAnswers { apiServiceResult }

        val actualResult = sut.getRandomCatInfo()
        val expectedResult = failure.buildLeft()

        assertEquals(expectedResult, actualResult)
    }
}