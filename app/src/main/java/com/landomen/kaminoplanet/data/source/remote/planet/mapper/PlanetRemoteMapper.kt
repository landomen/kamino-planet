package com.landomen.kaminoplanet.data.source.remote.planet.mapper

import com.landomen.kaminoplanet.data.entity.planet.PlanetEntity
import com.landomen.kaminoplanet.data.source.remote.base.mapper.RemoteModelMapper
import com.landomen.kaminoplanet.data.source.remote.planet.model.PlanetDto
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class PlanetRemoteMapper @Inject constructor() : RemoteModelMapper<PlanetEntity, PlanetDto> {

    override fun mapFromRemote(id: Int, remote: PlanetDto): PlanetEntity {
        return PlanetEntity(id,
                remote.name,
                remote.rotationPeriod,
                remote.orbitalPeriod,
                remote.diameter,
                remote.climate,
                remote.gravity,
                remote.terrain,
                remote.surfaceWater,
                remote.population,
                remote.residents.map {
                    try {
                        it.substringAfterLast("/").toInt()
                    } catch (e: NumberFormatException) {
                        0
                    }
                },
                remote.created,
                remote.edited,
                remote.imageUrl,
                remote.likesCount)
    }

}