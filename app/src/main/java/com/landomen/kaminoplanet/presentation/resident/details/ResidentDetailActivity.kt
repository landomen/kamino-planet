package com.landomen.kaminoplanet.presentation.resident.details

import android.content.Context
import android.content.Intent
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
import kotlinx.android.synthetic.main.activity_resident_details.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject

/**
 * Created by Domen Lanišnik on 05/03/2018.
 * domen.lanisnik@gmail.com
 */
class ResidentDetailActivity : BaseActivity(), ResidentDetailContract.View {

    companion object {
        private const val EXTRA_RESIDENT_ID = "ResidentId"

        fun createIntent(context: Context, residentId: Int): Intent {
            return context.intentFor<ResidentDetailActivity>(EXTRA_RESIDENT_ID to residentId)
        }
    }

    @Inject
    lateinit var presenter: ResidentDetailContract.Presenter
    @Inject
    lateinit var adapter: TitleValueRecyclerAdapter
    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resident_details)
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

    override fun setupToolbar() {
        setSupportActionBar(toolbar)
        setTitle(R.string.residents)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    override fun setupListeners() {
        residentImageView.setOnClickListener { presenter.onImageClicked() }
        residentLoadingView.retryListener = { presenter.onRetry() }
    }

    override fun setupInjection() {
        AndroidInjection.inject(this)
    }

    override fun initializePresenter() {
        presenter.takeView(this)
        presenter.initialize(intent.getIntExtra(EXTRA_RESIDENT_ID, 0))
    }

    override fun setToolbarTitle(title: String) {
        toolbar.title = title
    }

    override fun showDataLoading() {
        residentLoadingView.state = LoadingStateView.State.LOADING
        residentLoadingView.show()
        residentContentGroup.hide()
    }

    override fun hideDataLoading() {
        residentLoadingView.hide()
        residentContentGroup.show()
    }

    override fun showError() {
        residentLoadingView.state = LoadingStateView.State.ERROR
        residentLoadingView.show()
        residentImageView.showSnackbar(R.string.error_data_load)
    }

    override fun displayResidentName(name: String) {
        residentNameTextView.text = name
    }

    override fun displayResidentImage(imageUrl: String) {
        Glide.with(this)
                .load(imageUrl)
                .apply(RequestOptions()
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher))
                .listener(onFailure = {
                    presenter.onImageLoadingFailed()
                })
                .into(residentImageView)
    }

    override fun displayImageLoadingError() {
        residentImageView.showSnackbar(R.string.error_image_load)
    }

    override fun displayResidentDetails(details: List<TitleValue>) {
        adapter.items = details
    }

    override fun openImagePreview(imageUrl: String?) {
        navigator.openImagePreview(this, imageUrl)
    }

    private fun setupRecyclerView() {
        residentRecyclerView.layoutManager = LinearLayoutManager(this)
        residentRecyclerView.showSeparatorLines()
        residentRecyclerView.adapter = adapter
    }
}