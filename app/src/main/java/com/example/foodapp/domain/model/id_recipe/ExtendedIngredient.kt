package com.example.foodapp.domain.model.id_recipe

import com.example.foodapp.data.data_source.random_recipe_data_source.ExtendedIngredientDataSource

data class ExtendedIngredient(
    val original: String?,
    val image: String?,
    val id: Int?,
)

fun ExtendedIngredientDataSource.toExtendedIngredient(): ExtendedIngredient {
    return ExtendedIngredient(
        original = original,
        image = image,
        id = id,
    )
}