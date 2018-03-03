package com.landomen.kaminoplanet.data.source.remote.service

import com.landomen.kaminoplanet.data.source.remote.model.resident.ResidentDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Domen Lanišnik on 03/03/2018.
 * domen.lanisnik@gmail.com
 */
interface ResidentService {

    @GET("residents/{id}")
    fun getResidentDetails(@Path("id") id: Int): Single<ResidentDto>

}