package com.landomen.kaminoplanet.presentation.resident.list

import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import com.landomen.kaminoplanet.data.repository.resident.ResidentRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ResidentListPresenter @Inject constructor(private val residentRepository: ResidentRepository) : ResidentListContract.Presenter {

    private var view: ResidentListContract.View? = null
    private val compositeDisposable = CompositeDisposable()
    private var planetId: Int = 0

    // region Contract functions

    override fun initialize(planetId: Int) {
        this.planetId = planetId
        fetchResidents(planetId)
    }

    override fun takeView(view: ResidentListContract.View) {
        this.view = view
    }

    override fun destroy() {
        this.view = null
        if (compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    override fun onResidentClicked(resident: ResidentEntity) {
        view?.openResidentDetailsActivity(resident.id)
    }

    override fun onRetry() {
        fetchResidents(planetId)
    }

    // endregion

    // region Private functions

    private fun fetchResidents(planetId: Int) {
        view?.showDataLoading()
        residentRepository.getResidents(planetId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onResidentsFetched(it)
                }, {
                    onResidentsFetchError(it)
                })
                .addTo(compositeDisposable)
    }

    private fun onResidentsFetched(residents: List<ResidentEntity>) {
        view?.hideDataLoading()
        view?.displayResidents(residents)
    }

    private fun onResidentsFetchError(throwable: Throwable) {
        throwable.printStackTrace()
        view?.hideDataLoading()
        view?.showError()
    }

    // endregion
}