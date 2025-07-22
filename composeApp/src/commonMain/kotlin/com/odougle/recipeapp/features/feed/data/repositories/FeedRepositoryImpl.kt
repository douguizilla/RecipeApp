package com.odougle.recipeapp.features.feed.data.repositories

import com.odougle.recipeapp.features.commom.domain.entities.RecipeItem
import com.odougle.recipeapp.features.feed.data.datasources.FeedLocalDataSource
import com.odougle.recipeapp.features.feed.data.datasources.FeedRemoteDataSource
import com.odougle.recipeapp.features.feed.domain.repositories.FeedRepository

class FeedRepositoryImpl(
    private val localDataSource: FeedLocalDataSource,
    private val remoteDataSource: FeedRemoteDataSource
) : FeedRepository {
    override suspend fun getRecipesList(): Result<List<RecipeItem>> {
        return try {
            val recipeListCache = localDataSource.getRecipesList()
            val count = recipeListCache.count()
            return if (count > 0){
                Result.success(recipeListCache)
            }else{
                val recipeListRemote = remoteDataSource.getRecipesList()
                localDataSource.saveRecipesList(recipeListRemote)
                Result.success(recipeListRemote)
            }
        }catch (e: Exception){
            Result.failure(e)
        }
    }
}