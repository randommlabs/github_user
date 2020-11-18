package com.randommlabs.github_info.modules.github_search.di

import com.randommlabs.github_info.base.networks.GithubApiService
import com.randommlabs.github_info.modules.github_search.GithubSearchViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by aditya on 17/11/20.
 */

@Module
class GithubSearchViewModule {

    @Provides
    fun provideGithubSearchViewModel(githubApiService: GithubApiService): GithubSearchViewModel {
        return GithubSearchViewModel(githubApiService)
    }

//    @PerActivity
//    @Provides
//    fun provideViewModelProvider(viewModel: GithubSearchViewModel): ViewModelProvider.Factory? {
//        return ViewModelProviderFactory(viewModel)
//    }
}

