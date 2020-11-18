package com.randommlabs.github_info.modules.github_search

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.randommlabs.github_info.R
import com.randommlabs.github_info.base.BaseActivity
import com.randommlabs.github_info.base.Utils
import com.randommlabs.github_info.databinding.ActivityMainBinding
import javax.inject.Inject


/**
 * Created by aditya on 15/11/20.
 */

open class GithubSearchView : BaseActivity<GithubSearchViewModel>() {

    var binding: ActivityMainBinding? = null

    @Inject
    lateinit var githubSearchViewModel : GithubSearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        AndroidInjection.inject(this);
        initBinding();
    }

    override fun getViewModel(): GithubSearchViewModel? {
        return null;
    }

    fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding?.lifecycleOwner=this
        binding?.githubSearchViewModel=githubSearchViewModel

    }
}