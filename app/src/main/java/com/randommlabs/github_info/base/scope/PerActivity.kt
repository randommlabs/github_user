package com.randommlabs.github_info.base.scope

import kotlin.annotation.Retention
import javax.inject.Scope

/**
 * Created by aditya on 17/11/20.
 */


@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class PerActivity