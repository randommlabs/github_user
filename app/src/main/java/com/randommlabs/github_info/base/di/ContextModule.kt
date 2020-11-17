package com.randommlabs.github_info.base.di

import android.content.Context
import com.randommlabs.github_info.BaseApplication
import dagger.Module
import dagger.Provides




/**
 * Created by aditya on 17/11/20.
 */

@Module
open class ContextModule() {
    private var context: Context?=BaseApplication.getInstance()


    @Provides
    fun context(): Context? {
        return this.context
    }

}