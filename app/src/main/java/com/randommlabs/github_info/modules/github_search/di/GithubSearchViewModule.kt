package com.randommlabs.github_info.modules.github_search.di

import com.randommlabs.github_info.base.networks.GithubApiService
import com.randommlabs.github_info.base.scope.PerActivity
import com.randommlabs.github_info.modules.github_search.GithubSearchViewModel
import dagger.Module
import dagger.Provides




/**
 * Created by aditya on 17/11/20.
 */

@Module
class GithubSearchViewModule {
    @PerActivity
    @Provides
    fun provideGithubSearchViewModel(githubApiService : GithubApiService): GithubSearchViewModel? {
        return GithubSearchViewModel(githubApiService)
    }
}