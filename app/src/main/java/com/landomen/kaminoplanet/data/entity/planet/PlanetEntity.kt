package com.landomen.kaminoplanet.data.entity.planet

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
data class PlanetEntity(var id: Int,
                        val name: String?,
                        val rotationPeriod: Double?,
                        val orbitalPeriod: Double?,
                        val diameter: Double?,
                        val climate: String?,
                        val gravity: String?,
                        val terrain: String?,
                        val surfaceWater: Double?,
                        val population: Long?,
                        val residents: List<Int>,
                        val created: String?,
                        val edited: String?,
                        val imageUrl: String?,
                        val likesCount: Int)