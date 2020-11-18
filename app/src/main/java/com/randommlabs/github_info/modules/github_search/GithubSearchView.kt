package com.randommlabs.github_info.modules.github_search

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.randommlabs.github_info.R
import com.randommlabs.github_info.base.BaseActivity
import com.randommlabs.github_info.databinding.ActivityMainBinding
import com.randommlabs.github_info.modules.github_search.fragments.RepoListFragment
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
        githubSearchViewModel.navigateEvent.observe(this, Observer {
//            if (it == "open fragment") {
                val fragment: Fragment
                fragment = RepoListFragment()
                loadFragment(fragment)
//            }
        })
        return githubSearchViewModel;
    }

    fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding?.lifecycleOwner=this
        binding?.githubSearchViewModel=githubSearchViewModel

    }

    open fun loadFragment(fragment: Fragment?) {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction() //This won't show a blank page when android back press button is clicked from fragment
                //.addToBackStack(null)
                .replace(R.id.container, fragment)
                .commit()
        }
    }
}