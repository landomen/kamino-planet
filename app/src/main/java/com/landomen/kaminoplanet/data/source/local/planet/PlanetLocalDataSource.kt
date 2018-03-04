package com.landomen.kaminoplanet.data.source.local.planet

import com.landomen.kaminoplanet.data.entity.planet.PlanetEntity
import com.landomen.kaminoplanet.data.repository.planet.source.PlanetLocalSource
import com.landomen.kaminoplanet.data.source.local.base.db.StarWarsDatabase
import com.landomen.kaminoplanet.data.source.local.planet.mapper.PlanetLocalMapper
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class PlanetLocalDataSource @Inject constructor(private val database: StarWarsDatabase,
                                                private val mapper: PlanetLocalMapper) : PlanetLocalSource {

    override fun getPlanet(id: Int): Flowable<PlanetEntity> {
        return database.planetDao().getPlanetById(id)
                .map { mapper.mapFromLocal(it) }
    }

    override fun savePlanet(planet: PlanetEntity) {
        database.planetDao().insertPlanet(mapper.mapToLocal(planet))
    }
}