package com.landomen.kaminoplanet.presentation.resident.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.landomen.kaminoplanet.R
import com.landomen.kaminoplanet.data.entity.resident.ResidentEntity
import com.landomen.kaminoplanet.presentation.base.BaseActivity
import com.landomen.kaminoplanet.presentation.common.view.LoadingStateView
import com.landomen.kaminoplanet.presentation.resident.list.adapter.ResidentsRecyclerAdapter
import com.landomen.kaminoplanet.util.extensions.hide
import com.landomen.kaminoplanet.util.extensions.show
import com.landomen.kaminoplanet.util.extensions.showSeparatorLines
import com.landomen.kaminoplanet.util.extensions.showSnackbar
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_resident_list.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 04/03/2018.
 * domen.lanisnik@gmail.com
 */
class ResidentListActivity : BaseActivity(), ResidentListContract.View {

    companion object {
        private const val EXTRA_PLANET_ID = "PlanetId"

        fun createIntent(context: Context, planetId: Int): Intent {
            return context.intentFor<ResidentListActivity>(EXTRA_PLANET_ID to planetId)
        }
    }

    @Inject
    lateinit var presenter: ResidentListContract.Presenter

    @Inject
    lateinit var adapter: ResidentsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resident_list)
        setupInjection()
        setupToolbar()
        setupListeners()
        setupRecyclerView()
        initializePresenter()
    }

    override fun setupToolbar() {
        setSupportActionBar(toolbar)
        setTitle(R.string.residents)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    override fun setupListeners() {
        adapter.listener = { presenter.onResidentClicked(it) }
        residentsLoadingView.retryListener = { presenter.onRetryClicked() }
    }

    override fun setupInjection() {
        AndroidInjection.inject(this)
    }

    override fun initializePresenter() {
        presenter.takeView(this)
        presenter.initialize(intent.getIntExtra(EXTRA_PLANET_ID, 0))
    }

    override fun showDataLoading() {
        residentsLoadingView.state = LoadingStateView.State.LOADING
        residentsLoadingView.show()
        residentsRecyclerView.hide()
    }

    override fun hideDataLoading() {
        residentsLoadingView.hide()
        residentsRecyclerView.show()
    }

    override fun displayError() {
        residentsLoadingView.state = LoadingStateView.State.ERROR
        residentsLoadingView.show()
        residentsRecyclerView.hide()
        residentsLoadingView.showSnackbar(R.string.error_data_load)
    }

    override fun displayResidents(residents: List<ResidentEntity>) {
        adapter.items = residents
    }

    override fun openResidentDetailsActivity(residentId: Int) {

    }

    private fun setupRecyclerView() {
        residentsRecyclerView.layoutManager = LinearLayoutManager(this)
        residentsRecyclerView.showSeparatorLines()
        residentsRecyclerView.adapter = adapter
    }


}