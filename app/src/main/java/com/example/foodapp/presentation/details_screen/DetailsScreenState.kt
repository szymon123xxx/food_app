package com.example.foodapp.presentation.details_screen

import com.example.foodapp.domain.model.id_recipe.ExtendedIngredient
data class DetailsScreenState(
    val title: String? = "",
    val image: String? = "",
    val isLoading: Boolean = false,
    val error: String = "",
)

data class IngredientsScreenState(
    val extendedIngredients: List<ExtendedIngredient>? = null,
)

data class DescriptionScreenState(
    val instructions: String?,
    val summary: String?,
    val winePairing: String?,
)