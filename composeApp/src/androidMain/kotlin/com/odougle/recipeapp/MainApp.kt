package com.odougle.recipeapp

import android.app.Application
import com.odougle.recipeapp.dbFactory.DatabaseFactory
import com.odougle.recipeapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

class MainApp : Application() {
    private val androidModules = module{
        single { DatabaseFactory(applicationContext) }
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