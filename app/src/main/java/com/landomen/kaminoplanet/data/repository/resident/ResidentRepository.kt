package com.landomen.kaminoplanet.data.repository.resident

import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import io.reactivex.Single

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
interface ResidentRepository {

    fun getResidents(planetId: Int): Single<List<ResidentEntity>>

    fun getResident(residentId: Int): Single<ResidentEntity>

}