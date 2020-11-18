package com.randommlabs.github_info.base.di

import com.randommlabs.github_info.BaseApplication
import com.randommlabs.github_info.base.ActivityBuilder
import com.randommlabs.github_info.base.scope.ApplicationScope

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by aditya on 17/11/20.
 */

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        BaseApplicationModule::class,
        ActivityBuilder::class
    ]
)

interface BaseApplicationComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApplication?>()
}