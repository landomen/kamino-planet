package com.landomen.kaminoplanet.data.source.remote.planet

import com.landomen.kaminoplanet.data.entity.planet.PlanetEntity
import com.landomen.kaminoplanet.data.source.remote.planet.mapper.PlanetRemoteMapper
import com.landomen.kaminoplanet.data.source.remote.planet.service.PlanetService
import com.landomen.kaminoplanet.data.repository.planet.source.PlanetRemoteSource
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class PlanetRemoteDataSource @Inject constructor(private val planetService: PlanetService,
                                                 private val planetMapper: PlanetRemoteMapper) : PlanetRemoteSource {

    override fun getPlanetDetails(id: Int): Single<PlanetEntity> {
        return planetService.getPlanetDetails(id)
                .map { planetMapper.mapFromRemote(it) }
    }

    override fun likePlanet(id: Int): Single<Int> {
        return planetService.likePlanet(id)
                .map { it.likes }
    }

}