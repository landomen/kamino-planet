package com.landomen.kaminoplanet.data.source.remote.resident

import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import com.landomen.kaminoplanet.data.source.remote.resident.mapper.ResidentRemoteMapper
import com.landomen.kaminoplanet.data.source.remote.resident.service.ResidentService
import com.landomen.kaminoplanet.data.repository.resident.source.ResidentRemoteSource
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ResidentRemoteDataSource @Inject constructor(private val residentService: ResidentService,
                                                   private val residentMapper: ResidentRemoteMapper) : ResidentRemoteSource {

    override fun getResidentDetails(id: Int): Single<ResidentEntity> {
        return residentService.getResidentDetails(id)
                .map { residentMapper.mapFromRemote(id, it) }
    }

}