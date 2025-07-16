package com.odougle.recipeapp

import com.odougle.recipeapp.dbFactory.DatabaseFactory
import com.odougle.recipeapp.di.initKoin
import org.koin.dsl.module

val iosModules = module {
    single{ DatabaseFactory() }
}

fun initKoinIOS() = initKoin(additionalModule = listOf(iosModules))