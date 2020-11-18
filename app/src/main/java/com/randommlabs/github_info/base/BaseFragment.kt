package com.randommlabs.github_info.base

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.android.DaggerFragment


/**
 * Created by aditya on 17/11/20.
 */

abstract class BaseFragment<T : ViewModel?> : dagger.android.support.DaggerFragment() {
    private var viewModel: T? = null

    abstract fun getViewModel(): T


    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = getViewModel()
    }
}