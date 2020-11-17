package com.randommlabs.github_info

import com.randommlabs.github_info.base.di.DaggerBaseApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by aditya on 16/11/20.
 */

open class BaseApplication:DaggerApplication(){

    companion object {
        private var instance: BaseApplication? = null
        fun getInstance(): BaseApplication? {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance=this;
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication?> {
        return DaggerBaseApplicationComponent.builder().create(this);
    }

}