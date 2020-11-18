package com.randommlabs.github_info.modules.github_search.fragments.di

import com.randommlabs.github_info.modules.github_search.fragments.RepoListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector




/**
 * Created by aditya on 18/11/20.
 */
@Module
open abstract class RepoListProvider {

    @ContributesAndroidInjector(modules = [RepoListModule::class])
    abstract fun provideRepoListFragment(): RepoListFragment?
}