package com.odougle.recipeapp.features.commom.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeListDTO(
    @SerialName("meals")
    val meals: List<RecipeItemDTO>
)