package com.odougle.recipeapp.dbFactory

import app.cash.sqldelight.db.SqlDriver

const val DATABASE_NAME = "cmpapp.db"

expect class DatabaseFactory {
    suspend fun createDriver() : SqlDriver
}