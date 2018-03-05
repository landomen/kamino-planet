package com.landomen.kaminoplanet.presentation.planet

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.landomen.kaminoplanet.R
import com.landomen.kaminoplanet.presentation.base.BaseActivity
import com.landomen.kaminoplanet.presentation.base.Navigator
import com.landomen.kaminoplanet.presentation.common.adapter.TitleValueRecyclerAdapter
import com.landomen.kaminoplanet.presentation.common.model.TitleValue
import com.landomen.kaminoplanet.presentation.common.view.LoadingStateView
import com.landomen.kaminoplanet.util.extensions.*
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_planet.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class PlanetActivity : BaseActivity(), PlanetContract.View {

    @Inject
    lateinit var presenter: PlanetContract.Presenter
    @Inject
    lateinit var adapter: TitleValueRecyclerAdapter
    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet)
        setupToolbar()
        setupInjection()
        setupListeners()
        setupRecyclerView()
        initializePresenter()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    // region Contract methods

    override fun setupToolbar() {
        setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.app_name)
    }

    override fun setupInjection() {
        AndroidInjection.inject(this)
    }

    override fun setupListeners() {
        planetImageView.setOnClickListener { presenter.onImageClicked() }
        planetLikeActionImageButton.setOnClickListener { presenter.onPlanetLikeClicked() }
        planetViewResidentsButton.setOnClickListener { presenter.onViewResidentsClicked() }
        planetLoadingView.retryListener = { presenter.onRetryClicked() }
    }

    override fun initializePresenter() {
        presenter.takeView(this)
        presenter.initialize(10)
    }

    override fun showDataLoading() {
        planetLoadingView.state = LoadingStateView.State.LOADING
        planetLoadingView.show()
        planetContentGroup.hide()
    }

    override fun hideDataLoading() {
        planetLoadingView.hide()
        planetContentGroup.show()
    }

    override fun displayError() {
        planetLoadingView.state = LoadingStateView.State.ERROR
        planetLoadingView.show()
        planetImageView.showSnackbar(R.string.error_data_load)
    }

    override fun displayPlanetName(name: String) {
        planetNameTextView.text = name
    }

    override fun displayPlanetLikesCount(count: Int) {
        planetLikesTextView.text = count.toString()
    }

    override fun displayPlanetImage(imageUrl: String) {
        Glide.with(this)
                .load(imageUrl)
                .apply(RequestOptions()
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher))
                .into(planetImageView)
    }

    override fun displayPlanetDetails(details: List<TitleValue>) {
        adapter.items = details
    }

    override fun toggleViewResidentsButton(visible: Boolean) {
        planetViewResidentsButton.toggleVisibility(visible)
    }

    override fun togglePlanetLikeButton(visible: Boolean) {
        planetLikeActionImageButton.toggleVisibility(visible)
    }

    override fun displayLikeSuccess() {
        planetImageView.showSnackbar(R.string.success_planet_like)
    }

    override fun displayLikeError() {
        planetImageView.showSnackbar(R.string.error_planet_like)
    }

    override fun openImagePreview(imageUrl: String?) {
        navigator.openImagePreview(this, imageUrl)
    }

    override fun openResidentsActivity(planetId: Int, residents: List<Int>) {
        navigator.openResidentsList(this, planetId)
    }

    // endregion

    private fun setupRecyclerView() {
        planetRecyclerView.layoutManager = LinearLayoutManager(this)
        planetRecyclerView.showSeparatorLines()
        planetRecyclerView.adapter = adapter
    }


}
