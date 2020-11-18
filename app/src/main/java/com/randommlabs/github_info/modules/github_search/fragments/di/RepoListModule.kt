package com.randommlabs.github_info.modules.github_search.fragments.di

import com.randommlabs.github_info.base.networks.GithubApiService
import com.randommlabs.github_info.modules.github_search.fragments.RepoListViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by aditya on 18/11/20.
 */

@Module
open class RepoListModule{

    @Provides
    fun ProvideRepoListViewModel(githubApiService: GithubApiService): RepoListViewModel
    {
        return RepoListViewModel(githubApiService)
    }
}