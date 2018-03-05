package com.landomen.kaminoplanet.data.repository.planet.source

import com.landomen.kaminoplanet.data.entity.planet.PlanetEntity
import io.reactivex.Single

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
interface PlanetLocalSource {

    fun getPlanet(id: Int): Single<PlanetEntity>

    fun savePlanet(planet: PlanetEntity)

    fun savePlanetAsLiked(planetId: Int)

    fun isPlanetLiked(planetId: Int): Single<Boolean>

}