package com.odougle.recipeapp.dbFactory

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.odougle.recipeapp.RecipeAppCmpAppDb
import com.odougle.recipeapp.dbFactory.DATABASE_NAME as DB_FILE_NAME

actual class DatabaseFactory(
    private val context: Context
) {
    actual suspend fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            RecipeAppCmpAppDb.Schema.synchronous(),
            context,
            DB_FILE_NAME
        )
    }
}