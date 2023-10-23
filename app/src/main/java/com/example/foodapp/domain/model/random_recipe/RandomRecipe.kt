package com.example.foodapp.domain.model.random_recipe

import com.example.foodapp.data.data_source.api.random_recipe_data_source.RandomRecipeDataSource

data class RandomRecipe(
    val recipes: List<Recipe>?
)

fun RandomRecipeDataSource.toRandomRecipe(): RandomRecipe {
    return RandomRecipe(
        recipes = recipesDataSources?.map { it.toRecipe() }
    )
}