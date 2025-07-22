package com.odougle.recipeapp.features.feed.domain.repositories

import com.odougle.recipeapp.features.commom.domain.entities.RecipeItem

interface FeedRepository {
    suspend fun getRecipesList() : Result<List<RecipeItem>>
}