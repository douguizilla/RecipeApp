package com.odougle.recipeapp.features.commom.data.database

import com.odougle.recipeapp.Recipe
import com.odougle.recipeapp.features.commom.domain.entities.RecipeItem

fun recipeEntityMapper(recipe: Recipe) = RecipeItem(
    id = recipe.id,
    title = recipe.title,
    description = recipe.description,
    category = recipe.category,
    area = recipe.area,
    imageUrls = recipe.imageUrl,
    youtubeUrl = recipe.youtubeLink,
    ingredients = recipe.ingredients,
    instructions = recipe.instructions,
    isFavorite = recipe.isFavorite == 1L,
    rating = recipe.rating,
    duration = recipe.duration ?: "20 Mins",
    difficulty = recipe.difficulty ?: "Easy"
)