package com.example.foodapp.presentation.recipes_screen

import com.example.foodapp.domain.model.random_recipe.RandomRecipe

data class RecipesScreenState(
    val data: RandomRecipe? = null,
    val isLoading: Boolean = false,
    val error: String = "",
)