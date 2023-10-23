package com.example.foodapp.domain.model.id_recipe

import com.example.foodapp.data.data_source.api.id_recipe_data_source.IdRecipeDataSource

data class IdRecipe(
    val title: String?,
    val image: String?,
    val extendedIngredients: List<ExtendedIngredient>?,
    val instructions: String?,
    val summary: String?,
    val readyInMinutes: Int?,
    val winePairing: String?,
)

fun IdRecipeDataSource.toIdRecipe(): IdRecipe {
    return IdRecipe(
        image = image,
        extendedIngredients = extendedIngredientsDataSource?.map { it.toExtendedIngredient() },
        instructions = instructions,
        summary = summary,
        readyInMinutes = readyInMinutes,
        winePairing = winePairing?.toWinePairing()?.pairingText,
        title = title
    )
}