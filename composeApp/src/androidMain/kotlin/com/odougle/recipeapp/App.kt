package com.odougle.recipeapp

import android.app.Application
import com.odougle.recipeapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class App : Application() {
    private val androidModules = module{

    }

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    fun setupKoin(){
        initKoin(additionalModule = listOf(androidModules)) {
            androidContext(applicationContext)
        }
    }
}