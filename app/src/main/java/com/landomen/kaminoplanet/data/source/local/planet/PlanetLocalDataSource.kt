package com.landomen.kaminoplanet.data.source.local.planet

import com.landomen.kaminoplanet.data.entity.planet.PlanetEntity
import com.landomen.kaminoplanet.data.repository.planet.source.PlanetLocalSource
import com.landomen.kaminoplanet.data.source.local.base.db.StarWarsDatabase
import com.landomen.kaminoplanet.data.source.local.planet.mapper.PlanetLocalMapper
import com.landomen.kaminoplanet.data.source.local.planet.model.PlanetLikeCached
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class PlanetLocalDataSource @Inject constructor(private val database: StarWarsDatabase,
                                                private val mapper: PlanetLocalMapper) : PlanetLocalSource {

    override fun getPlanet(id: Int): Single<PlanetEntity> {
        return database.planetDao().getPlanetById(id)
                .map { mapper.mapFromLocal(it) }
    }

    override fun savePlanet(planet: PlanetEntity) {
        database.planetDao().insertPlanet(mapper.mapToLocal(planet))
    }

    override fun savePlanetAsLiked(planetId: Int) {
        database.planetDao().insertPlanetLike(PlanetLikeCached(planetId, true))
    }

    override fun isPlanetLiked(planetId: Int): Single<Boolean> {
        return Single.defer {
            Single.just(database.planetDao().getPlanetLike(planetId)?.liked ?: false)
        }
    }
}