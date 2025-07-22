package com.odougle.recipeapp.features.feed.data.datasources

import com.odougle.recipeapp.features.commom.domain.entities.RecipeItem

interface FeedLocalDataSource {
    suspend fun getRecipesList() : List<RecipeItem>
    suspend fun saveRecipesList(recipes: List<RecipeItem>)
}