package com.odougle.recipeapp.dbFactory

import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.odougle.recipeapp.RecipeAppCmpAppDb

actual class DatabaseFactory {
    actual suspend fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            RecipeAppCmpAppDb.Schema.synchronous(),
            DATABASE_NAME
        )
    }
}