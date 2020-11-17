package com.randommlabs.github_info.modules.github_search

import androidx.lifecycle.ViewModel
import com.randommlabs.github_info.base.networks.GithubApiService
import javax.inject.Inject


/**
 * Created by aditya on 15/11/20.
 */

class GithubSearchViewModel : ViewModel {

    var githubApiService: GithubApiService? = null

    @Inject
    constructor(githubApiService:GithubApiService? ) {
        this.githubApiService = githubApiService;
    }
}