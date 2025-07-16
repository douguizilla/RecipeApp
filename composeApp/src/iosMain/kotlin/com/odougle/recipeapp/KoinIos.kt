package com.odougle.recipeapp

import com.odougle.recipeapp.di.initKoin
import org.koin.dsl.module

val iosModules = module {

}

fun initKoinIOS() = initKoin(additionalModule = listOf(iosModules))