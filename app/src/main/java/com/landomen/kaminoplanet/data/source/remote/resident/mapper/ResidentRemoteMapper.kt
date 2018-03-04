package com.landomen.kaminoplanet.data.source.remote.resident.mapper

import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import com.landomen.kaminoplanet.data.source.remote.base.mapper.RemoteModelMapper
import com.landomen.kaminoplanet.data.source.remote.resident.model.ResidentDto
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ResidentRemoteMapper @Inject constructor() : RemoteModelMapper<ResidentEntity, ResidentDto> {

    override fun mapFromRemote(remote: ResidentDto): ResidentEntity {
        return ResidentEntity(remote.name,
                remote.height,
                remote.mass,
                remote.hairColor,
                remote.skinColor,
                remote.eyeColor,
                remote.birthYear,
                remote.gender,
                remote.homeworld,
                remote.created,
                remote.edited,
                remote.imageUrl)
    }

}