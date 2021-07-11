package com.marinj.catfacts.feature.catinfo.data.mapper

import com.marinj.catfacts.feature.catinfo.data.model.NetworkCatInfo
import com.marinj.catfacts.feature.catinfo.domain.model.CatInfo

class NetworkToDomainCatInfoMapper {

    fun map(origin: NetworkCatInfo): CatInfo {
        return with(origin) {
            CatInfo(fact)
        }
    }
}