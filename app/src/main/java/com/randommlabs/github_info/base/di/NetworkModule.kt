package com.randommlabs.github_info.base.di

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit


/**
 * Created by aditya on 17/11/20.
 */

@Module(includes = [ContextModule::class])
class NetworkModule {
    @Provides
    fun okHttpClient(
        logging: HttpLoggingInterceptor?
//        cache: Cache?
    ): OkHttpClient {
        val httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
        httpClientBuilder.writeTimeout(60, TimeUnit.SECONDS)
        httpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
        if (!httpClientBuilder.interceptors().contains(logging)) {
            httpClientBuilder.addInterceptor(logging)
        }
        //httpClientBuilder.cache(cache);
        return httpClientBuilder.build()
    }

    @Provides
    fun cache(cacheFile: File?): Cache {
        // 10 MB Cache
        return Cache(cacheFile, 10 * 1000 * 1000)
    }

    @Provides
    fun cacheFile(context: Context): File {
        return File(context.getCacheDir(), "okhttp3.cache")
    }

    @Provides
    fun loggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}