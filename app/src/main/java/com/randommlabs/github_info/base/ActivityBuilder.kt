package com.randommlabs.github_info.base

import com.randommlabs.github_info.modules.github_search.GithubSearchView
import com.randommlabs.github_info.modules.github_search.di.GithubSearchViewModule
import com.randommlabs.github_info.modules.github_search.fragments.di.RepoListProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector




/**
 * Created by aditya on 17/11/20.
 */

@Module
open abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [GithubSearchViewModule::class,RepoListProvider::class])
    abstract fun contributeGithubSearchView(): GithubSearchView?
}