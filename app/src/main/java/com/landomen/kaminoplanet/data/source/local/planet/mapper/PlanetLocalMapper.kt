package com.landomen.kaminoplanet.data.source.local.planet.mapper

import com.landomen.kaminoplanet.data.entity.planet.PlanetEntity
import com.landomen.kaminoplanet.data.source.local.base.mapper.LocalModelMapper
import com.landomen.kaminoplanet.data.source.local.planet.model.PlanetCached
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class PlanetLocalMapper @Inject constructor() : LocalModelMapper<PlanetEntity, PlanetCached> {

    override fun mapFromLocal(model: PlanetCached): PlanetEntity {
        return PlanetEntity(model.id,
                model.name,
                model.rotationPeriod,
                model.orbitalPeriod,
                model.diameter,
                model.climate,
                model.gravity,
                model.terrain,
                model.surfaceWater,
                model.population,
                model.residents,
                model.created,
                model.edited,
                model.imageUrl,
                model.likesCount)
    }

    override fun mapToLocal(model: PlanetEntity): PlanetCached {
        return PlanetCached(model.id,
                model.name,
                model.rotationPeriod,
                model.orbitalPeriod,
                model.diameter,
                model.climate,
                model.gravity,
                model.terrain,
                model.surfaceWater,
                model.population,
                model.residents,
                model.created,
                model.edited,
                model.imageUrl,
                model.likesCount)
    }
}