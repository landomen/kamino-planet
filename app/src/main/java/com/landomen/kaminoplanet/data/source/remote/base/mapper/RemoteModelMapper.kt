package com.landomen.kaminoplanet.data.source.remote.base.mapper

/**
 * Defines methods for mapping between remote models and data entity models.
 *
 * @param D Data entity type
 * @param R Remote model type
 */
interface RemoteModelMapper<out D, in R> {

    fun mapFromRemote(id: Int, remote: R): D

}