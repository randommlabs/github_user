package com.randommlabs.github_info.base.networks

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query


/**
 * Created by aditya on 17/11/20.
 */

interface GithubApiService {
    @GET("sample")
    fun getData(@Query("sample") Sample: Int, @HeaderMap headersMap: Map<String?, String?>?): Observable<String?>?
}