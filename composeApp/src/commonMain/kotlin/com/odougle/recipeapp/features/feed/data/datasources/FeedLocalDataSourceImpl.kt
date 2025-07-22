package com.odougle.recipeapp.features.feed.data.datasources

import com.odougle.recipeapp.features.commom.data.database.dao.RecipeDao
import com.odougle.recipeapp.features.commom.domain.entities.RecipeItem

class FeedLocalDataSourceImpl(
    private val recipeDao: RecipeDao
) : FeedLocalDataSource {
    override suspend fun getRecipesList() : List<RecipeItem>{
        return recipeDao.getAllRecipes()
    }

    override suspend fun saveRecipesList(recipes: List<RecipeItem>) {
        recipeDao.insertRecipesBulk(recipes)
    }
}