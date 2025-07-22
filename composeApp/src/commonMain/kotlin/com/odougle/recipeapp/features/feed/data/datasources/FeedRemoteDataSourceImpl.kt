package com.odougle.recipeapp.features.feed.data.datasources

import com.odougle.recipeapp.features.commom.data.api.BASE_URL
import com.odougle.recipeapp.features.commom.data.model.RecipeListDTO
import com.odougle.recipeapp.features.commom.data.model.toRecipe
import com.odougle.recipeapp.features.commom.domain.entities.RecipeItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class FeedRemoteDataSourceImpl(
    private val httpClient: HttpClient
) : FeedRemoteDataSource {
    override suspend fun getRecipesList() : List<RecipeItem>{
        val httpResponse = httpClient.get("${BASE_URL}search.php?f=b")
        val recipeListApiResponse = httpResponse.body<RecipeListDTO>()
        return recipeListApiResponse.meals.mapNotNull {
            it.toRecipe()
        }
    }
}