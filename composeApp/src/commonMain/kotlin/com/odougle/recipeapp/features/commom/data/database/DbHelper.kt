package com.odougle.recipeapp.features.commom.data.database

import com.odougle.recipeapp.RecipeAppCmpAppDb
import com.odougle.recipeapp.dbFactory.DatabaseFactory
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class DbHelper(
    private val driverFactory: DatabaseFactory
) {
    private var db: RecipeAppCmpAppDb? = null
    private val mutex = Mutex()

    suspend fun <Result: Any> withDatabase(block: suspend (RecipeAppCmpAppDb) -> Result) = mutex.withLock {
        if (db == null) db = createDb(driverFactory)

        return@withLock block(db!!)
    }

    private suspend fun createDb(driverFactory: DatabaseFactory) = RecipeAppCmpAppDb(driver = driverFactory.createDriver())
}