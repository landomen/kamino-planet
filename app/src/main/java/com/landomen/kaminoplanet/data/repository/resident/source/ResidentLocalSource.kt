package com.landomen.kaminoplanet.data.repository.resident.source

import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import io.reactivex.Flowable
import io.reactivex.Maybe

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
interface ResidentLocalSource {

    fun getResidents(): Flowable<List<ResidentEntity>>

    fun getResident(id: Int): Maybe<ResidentEntity>

    fun saveResident(resident: ResidentEntity)

}