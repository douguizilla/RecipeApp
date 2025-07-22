package com.odougle.recipeapp.features.feed.ui

import com.odougle.recipeapp.features.commom.domain.entities.RecipeItem

data class FeedUiState(
    val recipesList: List<RecipeItem> = emptyList(),
    val recipesListIsLoading: Boolean = true,
    val recipesListError: String? = null
)
