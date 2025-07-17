package com.odougle.recipeapp.features.feed.data.datasources

import com.odougle.recipeapp.features.commom.domain.entities.RecipeItem

interface FeedRemoteDataSource {
    suspend fun getRecipesList() : List<RecipeItem>
}