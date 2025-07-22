package com.odougle.recipeapp.di

import com.odougle.recipeapp.features.feed.data.datasources.FeedLocalDataSource
import com.odougle.recipeapp.features.feed.data.datasources.FeedLocalDataSourceImpl
import com.odougle.recipeapp.features.feed.data.datasources.FeedRemoteDataSource
import com.odougle.recipeapp.features.feed.data.datasources.FeedRemoteDataSourceImpl
import org.koin.dsl.module

fun dataModule() = module {
    single<FeedLocalDataSource> { FeedLocalDataSourceImpl(get()) }
    single<FeedRemoteDataSource> { FeedRemoteDataSourceImpl(get()) }
}