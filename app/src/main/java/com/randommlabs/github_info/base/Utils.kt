package com.randommlabs.github_info.base

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by aditya on 17/11/20.
 */

@Singleton
open class Utils {

    open var context : Context?=null;

    @Inject
    constructor(context:Context?)
    {
        this.context = context;
    }
}