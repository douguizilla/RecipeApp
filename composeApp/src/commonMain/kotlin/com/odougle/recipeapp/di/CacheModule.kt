package com.odougle.recipeapp.di

import com.odougle.recipeapp.features.commom.data.database.DbHelper
import com.odougle.recipeapp.features.commom.data.database.dao.RecipeDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

fun cacheModule() = module {
    single<CoroutineContext>{ Dispatchers.Default }
    single { CoroutineScope(get()) }
    single{ DbHelper(get()) }
    single{ RecipeDao(get()) }
}