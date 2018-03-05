package com.landomen.kaminoplanet.presentation.base

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity

@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity() {

    abstract fun setupToolbar()
    abstract fun setupListeners()
    abstract fun setupInjection()
    abstract fun initializePresenter()
}