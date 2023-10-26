package com.example.foodapp.domain.model.random_recipe

import com.example.foodapp.data.data_source.random_recipe_data_source.RecipeDataSource

data class Recipe(
    val id: Int?,
    val readyInMinutes: Int?,
    val image: String?,
    val title: String?,
    val pricePerServing: Double?,
)

fun RecipeDataSource.toRecipe(): Recipe {
    return Recipe(
        id = id,
        readyInMinutes = readyInMinutes,
        image = image,
        title = title,
        pricePerServing = pricePerServing,
    )
}
