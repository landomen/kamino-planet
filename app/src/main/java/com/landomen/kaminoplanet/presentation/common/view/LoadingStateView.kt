package com.landomen.kaminoplanet.presentation.common.view

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import com.landomen.kaminoplanet.R
import com.landomen.kaminoplanet.presentation.common.extensions.inflate
import com.landomen.kaminoplanet.presentation.common.extensions.toggleVisibility
import kotlinx.android.synthetic.main.view_loading_state.view.*
import kotlin.properties.Delegates

/**
 * Created by Domen Lanišnik on 05/03/2018.
 * domen.lanisnik@gmail.com
 */
class LoadingStateView(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    enum class State {
        LOADING, ERROR
    }

    var state: State by Delegates.observable(State.LOADING) { _, _, _ -> update() }
    var retryListener: (() -> Unit)? = null

    init {
        inflate(R.layout.view_loading_state, true)
        loadingRetryButton.setOnClickListener { retryListener?.invoke() }
    }

    private fun update() {
        loadingErrorGroup.toggleVisibility(state == State.ERROR)
        loadingProgressBar.toggleVisibility(state == State.LOADING)
    }

}