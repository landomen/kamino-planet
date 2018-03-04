package com.landomen.kaminoplanet.data.repository.planet

import com.landomen.kaminoplanet.data.entity.planet.PlanetEntity
import com.landomen.kaminoplanet.data.repository.planet.source.PlanetLocalSource
import com.landomen.kaminoplanet.data.repository.planet.source.PlanetRemoteSource
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class PlanetDataRepository @Inject constructor(private val localSource: PlanetLocalSource,
                                               private val remoteSource: PlanetRemoteSource) : PlanetRepository {

    override fun getPlanet(id: Int): Flowable<PlanetEntity> {
        return remoteSource.getPlanetDetails(id)
                .doOnSuccess { localSource.savePlanet(it) }
                .toFlowable()
    }

    override fun likePlanet(planetId: Int): Single<Int> {
        return remoteSource.likePlanet(planetId)
                .doOnSuccess { localSource.savePlanetAsLiked(planetId) }
    }

    override fun hasUserLikedPlanet(planetId: Int): Single<Boolean> {
        return localSource.isPlanetLiked(planetId)
    }
}