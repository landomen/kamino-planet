package com.landomen.kaminoplanet.presentation.planet.model

import com.landomen.kaminoplanet.R
import com.landomen.kaminoplanet.presentation.common.model.Title

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
enum class PlanetTitle(private val resId: Int) : Title {
    DIAMETER(R.string.planet_diameter),
    CLIMATE(R.string.planet_climate),
    GRAVITY(R.string.planet_gravity),
    TERRAIN(R.string.planet_terrain),
    ROTATIONAL_PERIOD(R.string.planet_rotational_period),
    ORBITAL_PERIOD(R.string.planet_orbital_period),
    SURFACE_WATER(R.string.planet_surface_water),
    POPULATION(R.string.planet_population),
    LIKES(R.string.planet_likes);

    override val stringResId: Int
        get() = resId
}