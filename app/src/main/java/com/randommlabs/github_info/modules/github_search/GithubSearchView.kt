package com.randommlabs.github_info.modules.github_search

import android.os.Bundle
import com.randommlabs.github_info.R
import com.randommlabs.github_info.base.BaseActivity
import dagger.android.AndroidInjection

/**
 * Created by aditya on 15/11/20.
 */

open class GithubSearchView : BaseActivity<GithubSearchViewModel>() {

//    private val binding by binding<GithubSearchViewBinding>(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this);
    }

    override fun getViewModel(): GithubSearchViewModel {
        TODO("Not yet implemented")
    }
}