package com.landomen.kaminoplanet.data.source.remote.service

import com.landomen.kaminoplanet.data.source.remote.model.planet.LikePlanetDto
import com.landomen.kaminoplanet.data.source.remote.model.planet.PlanetDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
interface PlanetService {

    @GET("planets/{id}")
    fun getPlanetDetails(@Path("id") id: Int): Single<PlanetDto>

    @POST("planets/{id}/like")
    fun likePlanet(@Path("id") id: Int): Single<LikePlanetDto>

}