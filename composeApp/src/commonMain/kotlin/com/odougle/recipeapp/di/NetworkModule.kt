package com.odougle.recipeapp.di

import com.odougle.recipeapp.features.commom.data.api.httpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

fun networkModule() = module {
    single<HttpClient> {
        httpClient
    }
}