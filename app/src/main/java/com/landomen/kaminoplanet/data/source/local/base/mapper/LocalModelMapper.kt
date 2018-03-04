package com.landomen.kaminoplanet.data.source.local.base.mapper

/**
 * Defines methods for mapping between local models and data entity models.
 *
 * @param D Data entity type
 * @param L Local model type
 */
interface LocalModelMapper<D, L> {

    fun mapFromLocal(model: L): D

    fun mapToLocal(model: D): L
}