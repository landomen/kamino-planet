package com.landomen.kaminoplanet.data.source.local.resident

import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import com.landomen.kaminoplanet.data.repository.resident.source.ResidentLocalSource
import com.landomen.kaminoplanet.data.source.local.base.db.StarWarsDatabase
import com.landomen.kaminoplanet.data.source.local.resident.mapper.ResidentLocalMapper
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ResidentLocalDataSource @Inject constructor(private val database: StarWarsDatabase,
                                                  private val mapper: ResidentLocalMapper) : ResidentLocalSource {

    override fun getResidents(planetId: Int): Flowable<List<ResidentEntity>> {
        return database.residentDao().getResidents(planetId)
                .map { it.map { mapper.mapFromLocal(it) } }
    }

    override fun getResident(id: Int): Maybe<ResidentEntity> {
        return database.residentDao().getResidentById(id)
                .map { mapper.mapFromLocal(it) }
    }

    override fun saveResident(resident: ResidentEntity) {
        database.residentDao().insertResident(mapper.mapToLocal(resident))
    }

}