package com.landomen.kaminoplanet.data.repository.resident

import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import com.landomen.kaminoplanet.data.repository.resident.source.ResidentLocalSource
import com.landomen.kaminoplanet.data.repository.resident.source.ResidentRemoteSource
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ResidentDataRepository @Inject constructor(private val remoteSource: ResidentRemoteSource,
                                                 private val localSource: ResidentLocalSource) : ResidentRepository {

    override fun getResidents(planetId: Int): Flowable<List<ResidentEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getResident(residentId: Int): Maybe<ResidentEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}