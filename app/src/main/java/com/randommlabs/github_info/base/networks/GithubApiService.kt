package com.randommlabs.github_info.base.networks

import com.randommlabs.github_info.modules.github_search.fragments.RepoData
import com.randommlabs.github_info.modules.github_search.models.UserDetails
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url


/**
 * Created by aditya on 17/11/20.
 */

interface GithubApiService {

    @GET("users/{user_id}")
    fun getData(@Path(value = "user_id", encoded = true) userId: String?): Observable<UserDetails>

    @GET("users/princessdharmy/repos")
    fun getRepos(): Observable<List<RepoData>>
}