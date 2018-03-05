package com.landomen.kaminoplanet.data.repository.resident.source

import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import io.reactivex.Single

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
interface ResidentLocalSource {

    fun getResidents(planetId: Int): Single<List<ResidentEntity>>

    fun getResident(id: Int): Single<ResidentEntity>

    fun saveResident(resident: ResidentEntity)

}