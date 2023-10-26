package com.example.foodapp.data.data_source.random_recipe_data_source

import com.google.gson.annotations.SerializedName

data class RandomRecipeDataSource(
    @SerializedName("recipes")
    val recipesDataSources: List<RecipeDataSource>?
)