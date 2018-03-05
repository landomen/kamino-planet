package com.landomen.kaminoplanet.presentation.common.extensions

import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.toggleVisibility(visible: Boolean) {
    if (visible) {
        show()
    } else {
        hide()
    }
}

fun ViewGroup.inflate(@LayoutRes resource: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(resource, this, attachToRoot)

fun RecyclerView.showSeparatorLines() = addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))

fun View.showSnackbar(@StringRes message: Int) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}

fun ImageView.loadImage(url: String) {
    Glide.with(context)
            .load(url)
            .into(this)
}