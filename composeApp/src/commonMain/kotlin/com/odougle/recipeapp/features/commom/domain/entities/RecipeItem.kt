package com.odougle.recipeapp.features.commom.domain.entities

data class RecipeItem(
    val id: Long,
    val title: String,
    val description: String,
    val category: String,
    val area: String,
    val imageUrls: String,
    val youtubeUrl: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val isFavorite: Boolean,
    val rating: Long,
    val duration: String = "20 Mins",
    val difficulty: String = "Easy",
)