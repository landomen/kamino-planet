package com.landomen.kaminoplanet.presentation.planet

import com.landomen.kaminoplanet.data.entity.planet.PlanetEntity
import com.landomen.kaminoplanet.data.repository.planet.PlanetRepository
import com.landomen.kaminoplanet.presentation.common.constants.AppConstants
import com.landomen.kaminoplanet.presentation.common.model.TitleValue
import com.landomen.kaminoplanet.presentation.planet.model.PlanetTitle
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
    private var planetId: Int = 0

    // region Contract functions

    override fun initialize(planetId: Int) {
        this.planetId = planetId
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

    override fun onViewResidentsClicked() {
        view?.openResidentsActivity(planetEntity?.id!!, planetEntity?.residents ?: listOf())
    }

    override fun onRetry() {
        fetchPlanetDetails(planetId)
    }

    override fun onPlanetLikeClicked() {
        view?.showDataLoading()
        view?.togglePlanetLikeButton(false)
        planetRepository.likePlanet(planetEntity?.id ?: 0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onPlanetLikedSuccessfully(it)
                }, {
                    onPlanetLikedError(it)
                })
                .addTo(compositeDisposable)
    }

    // endregion

    // region Private methods

    private fun fetchPlanetDetails(planetId: Int) {
        view?.showDataLoading()
        planetRepository.getPlanet(planetId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onPlanetDetailsFetched(it)
                    fetchPlanetLikeStatus(planetId)
                }, {
                    onPlanetDetailsFetchError(it)
                })
                .addTo(compositeDisposable)
    }

    private fun onPlanetDetailsFetched(planetEntity: PlanetEntity) {
        view?.displayPlanetName(planetEntity.name ?: AppConstants.VALUE_MISSING)
        view?.displayPlanetLikesCount(planetEntity.likesCount)
        planetEntity.imageUrl?.let {
            view?.displayPlanetImage(it)
        }
        view?.displayPlanetDetails(createPlanetDetails(planetEntity))
        view?.hideDataLoading()
        view?.toggleViewResidentsButton(!planetEntity.residents.isNotEmpty())
        this.planetEntity = planetEntity
    }

    private fun onPlanetDetailsFetchError(throwable: Throwable) {
        throwable.printStackTrace()
        view?.showError()
    }

    private fun createPlanetDetails(planet: PlanetEntity): List<TitleValue> {
        return listOf(TitleValue(PlanetTitle.ROTATIONAL_PERIOD, planet.rotationPeriod?.toString() ?: AppConstants.VALUE_MISSING),
                TitleValue(PlanetTitle.ORBITAL_PERIOD, planet.orbitalPeriod?.toString() ?: AppConstants.VALUE_MISSING),
                TitleValue(PlanetTitle.DIAMETER, planet.diameter?.toString() ?: AppConstants.VALUE_MISSING),
                TitleValue(PlanetTitle.CLIMATE, planet.climate ?: AppConstants.VALUE_MISSING),
                TitleValue(PlanetTitle.GRAVITY, planet.gravity ?: AppConstants.VALUE_MISSING),
                TitleValue(PlanetTitle.TERRAIN, planet.terrain ?: AppConstants.VALUE_MISSING),
                TitleValue(PlanetTitle.SURFACE_WATER, planet.surfaceWater?.toString() ?: AppConstants.VALUE_MISSING),
                TitleValue(PlanetTitle.POPULATION, planet.population?.toString() ?: AppConstants.VALUE_MISSING)
        )
    }

    private fun fetchPlanetLikeStatus(planetId: Int) {
        planetRepository.hasUserLikedPlanet(planetId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ liked ->
                    view?.togglePlanetLikeButton(!liked)
                }, {
                    view?.togglePlanetLikeButton(false)
                })
                .addTo(compositeDisposable)
    }

    private fun onPlanetLikedSuccessfully(newLikesCount: Int) {
        view?.hideDataLoading()
        view?.displayPlanetLikesCount(newLikesCount)
        view?.togglePlanetLikeButton(false)
        view?.displayLikeSuccess()
    }

    private fun onPlanetLikedError(throwable: Throwable) {
        throwable.printStackTrace()
        view?.hideDataLoading()
        view?.togglePlanetLikeButton(true)
        view?.displayLikeError()
    }

    // endregion

}