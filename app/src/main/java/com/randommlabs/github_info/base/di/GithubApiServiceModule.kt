package com.randommlabs.github_info.base.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.randommlabs.github_info.base.networks.GithubApiService
import com.randommlabs.github_info.base.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by aditya on 17/11/20.
 */

@Module(includes = [NetworkModule::class])
class GithubApiServiceModule {
    @Provides
    @ApplicationScope
    fun githubApiService(httpClient: OkHttpClient?): GithubApiService {
        val url: String = ""
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(httpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(GithubApiService::class.java)
    }
}