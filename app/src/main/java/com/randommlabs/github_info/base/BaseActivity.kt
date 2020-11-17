package com.randommlabs.github_info.base

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModel
import dagger.android.support.DaggerAppCompatActivity


/**
 * Created by aditya on 15/11/20.
 */

abstract class BaseActivity<T : ViewModel?> : DaggerAppCompatActivity() {
    private var viewModel: T? = null


    abstract fun getViewModel(): T

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = if (viewModel == null) getViewModel() else viewModel
    }
}