package com.landomen.kaminoplanet.presentation.resident.details

import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import com.landomen.kaminoplanet.data.repository.resident.ResidentRepository
import com.landomen.kaminoplanet.presentation.common.constants.AppConstants
import com.landomen.kaminoplanet.presentation.common.model.TitleValue
import com.landomen.kaminoplanet.presentation.resident.details.model.ResidentTitle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 05/03/2018.
 * domen.lanisnik@gmail.com
 */
class ResidentDetailPresenter @Inject constructor(private val residentRepository: ResidentRepository) : ResidentDetailContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private var view: ResidentDetailContract.View? = null
    private var residentId = 0
    private var resident: ResidentEntity? = null

    // region Contract functions

    override fun initialize(residentId: Int) {
        this.residentId = residentId
        fetchResidentDetails(residentId)
    }

    override fun takeView(view: ResidentDetailContract.View) {
        this.view = view
    }

    override fun destroy() {
        this.view = null
        if (compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    override fun onImageClicked() {
        view?.openImagePreview(resident?.imageUrl)
    }

    override fun onRetry() {
        fetchResidentDetails(residentId)
    }

    override fun onImageLoadingFailed() {
        view?.displayImageLoadingError()

    }

    // endregion

    // region Private functions

    private fun fetchResidentDetails(residentId: Int) {
        view?.showDataLoading()
        residentRepository.getResident(residentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onResidentDetailsFetched(it)
                }, {
                    onResidentDetailsFetchError(it)
                })
                .addTo(compositeDisposable)
    }

    private fun onResidentDetailsFetched(resident: ResidentEntity) {
        resident.name?.let {
            view?.setToolbarTitle(it)
        }
        resident.imageUrl?.let {
            view?.displayResidentImage(it)
        }
        view?.displayResidentName(resident.name ?: AppConstants.VALUE_MISSING)
        view?.displayResidentDetails(createResidentDetails(resident))
        view?.hideDataLoading()
        this.resident = resident
    }

    private fun onResidentDetailsFetchError(throwable: Throwable) {
        throwable.printStackTrace()
        view?.showError()
    }

    private fun createResidentDetails(resident: ResidentEntity): List<TitleValue> {
        return listOf(TitleValue(ResidentTitle.GENDER, resident.gender ?: AppConstants.VALUE_MISSING),
                TitleValue(ResidentTitle.BIRTH_YEAR, resident.birthYear ?: AppConstants.VALUE_MISSING),
                TitleValue(ResidentTitle.HEIGHT, resident.height?.toString() ?: AppConstants.VALUE_MISSING),
                TitleValue(ResidentTitle.MASS, resident.mass ?: AppConstants.VALUE_MISSING),
                TitleValue(ResidentTitle.HAIR_COLOR, resident.hairColor ?: AppConstants.VALUE_MISSING),
                TitleValue(ResidentTitle.SKIN_COLOR, resident.skinColor ?: AppConstants.VALUE_MISSING),
                TitleValue(ResidentTitle.EYE_COLOR, resident.eyeColor ?: AppConstants.VALUE_MISSING)
        )
    }

    // endregion
}