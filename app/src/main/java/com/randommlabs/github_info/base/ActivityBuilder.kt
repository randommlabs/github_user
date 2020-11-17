package com.randommlabs.github_info.base

import com.randommlabs.github_info.modules.github_search.GithubSearchView
import com.randommlabs.github_info.modules.github_search.di.GithubSearchViewModule
import dagger.Module
import dagger.android.ContributesAndroidInjector




/**
 * Created by aditya on 17/11/20.
 */

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [GithubSearchViewModule::class])
    abstract fun contributeGithubSearchView(): GithubSearchView?
//    @ContributesAndroidInjector(modules = [MainActivityModule::class, CategoryFragmentProvider::class, ProfileFragmentProvider::class, LeaderboardFragmentProvider::class])
//    abstract fun contributeMainActivity(): MainActivity?
}