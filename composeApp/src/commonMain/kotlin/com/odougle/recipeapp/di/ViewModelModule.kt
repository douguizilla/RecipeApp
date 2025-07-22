package com.odougle.recipeapp.di

import com.odougle.recipeapp.features.feed.ui.FeedViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {
    viewModel{
        FeedViewModel(get())
    }
}