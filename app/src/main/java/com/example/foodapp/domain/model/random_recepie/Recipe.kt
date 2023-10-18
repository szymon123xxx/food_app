package com.example.foodapp.domain.model.random_recepie

import com.example.foodapp.data.data_source.api.random_recipe_data_source.RecipeDataSource

data class Recipe(
    val readyInMinutes: Int?,
    val image: String?,
    val title: String?,
    val pricePerServing: Double?,
)

fun RecipeDataSource.toRecipe(): Recipe {
    return Recipe(
        readyInMinutes = readyInMinutes,
        image = image,
        title = title,
        pricePerServing = pricePerServing,
    )
}
