package com.landomen.kaminoplanet.presentation.planet

import com.landomen.kaminoplanet.data.entity.planet.PlanetEntity
import com.landomen.kaminoplanet.data.repository.planet.PlanetRepository
import com.landomen.kaminoplanet.presentation.common.constants.AppConstants
import com.landomen.kaminoplanet.presentation.common.model.Title
import com.landomen.kaminoplanet.presentation.common.model.TitleValue
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class PlanetPresenter @Inject constructor(private val planetRepository: PlanetRepository) : PlanetContract.Presenter {

    private var view: PlanetContract.View? = null
    private val compositeDisposable = CompositeDisposable()
    private var planetEntity: PlanetEntity? = null

    override fun initialize(planetId: Int) {
        view?.showDataLoading()
        fetchPlanetDetails(planetId)
    }

    override fun takeView(view: PlanetContract.View) {
        this.view = view
    }

    override fun destroy() {
        this.view = null
        if (compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    override fun onImageClicked() {
        view?.openImagePreview(planetEntity?.imageUrl)
    }

    private fun fetchPlanetDetails(planetId: Int) {
        planetRepository.getPlanet(planetId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.displayPlanetName(it.name ?: "-")
                    view?.displayPlanetLikesCount(it.likesCount)
                    it.imageUrl?.let {
                        view?.displayPlanetImage(it)
                    }
                    view?.displayPlanetDetails(createPlanetDetails(it))
                    view?.hideDataLoading()
                    planetEntity = it
                }, {

                })
                .addTo(compositeDisposable)
    }

    private fun createPlanetDetails(planet: PlanetEntity): List<TitleValue> {
        return listOf(TitleValue(Title.ROTATIONAL_PERIOD, planet.rotationPeriod?.toString()
                ?: AppConstants.VALUE_MISSING),
                TitleValue(Title.ORBITAL_PERIOD, planet.orbitalPeriod?.toString()
                        ?: AppConstants.VALUE_MISSING),
                TitleValue(Title.DIAMETER, planet.diameter?.toString()
                        ?: AppConstants.VALUE_MISSING),
                TitleValue(Title.CLIMATE, planet.climate ?: AppConstants.VALUE_MISSING),
                TitleValue(Title.GRAVITY, planet.gravity ?: AppConstants.VALUE_MISSING),
                TitleValue(Title.TERRAIN, planet.terrain ?: AppConstants.VALUE_MISSING),
                TitleValue(Title.SURFACE_WATER, planet.surfaceWater?.toString()
                        ?: AppConstants.VALUE_MISSING),
                TitleValue(Title.POPULATION, planet.population?.toString()
                        ?: AppConstants.VALUE_MISSING)
        )
    }

}