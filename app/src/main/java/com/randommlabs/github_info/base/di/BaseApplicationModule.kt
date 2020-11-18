package com.randommlabs.github_info.base.di

import android.content.Context
import com.randommlabs.github_info.BaseApplication
import com.randommlabs.github_info.base.Utils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by aditya on 17/11/20.
 */

@Module(includes = [GithubApiServiceModule::class])
class BaseApplicationModule {

    @Provides
    fun provideContext(application: BaseApplication?): Context? {
        return application
    }


    @Provides
    fun provideUtils(context: Context?): Utils? {
        return Utils(context)
    }
}