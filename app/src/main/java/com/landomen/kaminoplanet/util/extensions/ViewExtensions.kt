package com.landomen.kaminoplanet.util.extensions

import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun ViewGroup.inflate(@LayoutRes resource: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(resource, this, attachToRoot)

fun RecyclerView.showSeparatorLines() = addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))

fun View.showSnackbar(@StringRes message: Int) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
}