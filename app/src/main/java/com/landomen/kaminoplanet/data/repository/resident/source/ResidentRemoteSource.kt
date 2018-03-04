package com.landomen.kaminoplanet.data.repository.resident.source

import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import io.reactivex.Single

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
interface ResidentRemoteSource {

    fun getResidentDetails(id: Int): Single<ResidentEntity>

}