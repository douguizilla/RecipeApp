package com.odougle.recipeapp.features.feed.data.datasources

import com.odougle.recipeapp.features.commom.domain.entities.RecipeItem

class FeedRemoteDataSourceImpl : FeedRemoteDataSource {
    override suspend fun getRecipesList() : List<RecipeItem>{
        TODO()
    }
}