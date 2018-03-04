package com.landomen.kaminoplanet.data.repository.planet

import com.landomen.kaminoplanet.data.entity.planet.PlanetEntity
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
interface PlanetRepository {

    fun getPlanet(id: Int): Flowable<PlanetEntity>

    /**
     * Likes this planet.
     *
     * @return New likes count
     */
    fun likePlanet(planetId: Int): Single<Int>

    fun hasUserLikedPlanet(planetId: Int): Single<Boolean>

}