package com.landomen.kaminoplanet.data.source.local.resident.mapper

import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import com.landomen.kaminoplanet.data.source.local.base.mapper.LocalModelMapper
import com.landomen.kaminoplanet.data.source.local.resident.model.ResidentCached
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ResidentLocalMapper @Inject constructor() : LocalModelMapper<ResidentEntity, ResidentCached> {

    override fun mapFromLocal(model: ResidentCached): ResidentEntity {
        return ResidentEntity(model.id,
                model.name,
                model.height,
                model.mass,
                model.hairColor,
                model.skinColor,
                model.eyeColor,
                model.birthYear,
                model.gender,
                model.homeworld,
                model.created,
                model.edited,
                model.imageUrl)
    }

    override fun mapToLocal(model: ResidentEntity): ResidentCached {
        return ResidentCached(model.id,
                model.name,
                model.height,
                model.mass,
                model.hairColor,
                model.skinColor,
                model.eyeColor,
                model.birthYear,
                model.gender,
                model.homeworld,
                model.created,
                model.edited,
                model.imageUrl)
    }
}