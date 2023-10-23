package com.example.foodapp.data.data_source.api.id_recipe_data_source

import com.example.foodapp.data.data_source.api.random_recipe_data_source.AnalyzedInstructionDataSource
import com.example.foodapp.data.data_source.api.random_recipe_data_source.ExtendedIngredientDataSource
import com.google.gson.annotations.SerializedName

data class IdRecipeDataSource(
    @SerializedName("analyzedInstructions")
    val analyzedInstructionsDataSource: List<AnalyzedInstructionDataSource>?,
    val cheap: Boolean?,
    val creditsText: String?,
    val cuisines: List<Any>?,
    val dairyFree: Boolean?,
    val diets: List<String?>,
    val dishTypes: List<String>?,
    @SerializedName("extendedIngredients")
    val extendedIngredientsDataSource: List<ExtendedIngredientDataSource>?,
    val gaps: String?,
    val glutenFree: Boolean?,
    val healthScore: Double?,
    val id: Int?,
    val image: String?,
    val imageType: String?,
    val instructions: String?,
    val ketogenic: Boolean?,
    val license: String?,
    val lowFodmap: Boolean?,
    val occasions: List<Any>?,
    val pricePerServing: Double?,
    val readyInMinutes: Int?,
    val servings: Int?,
    val sourceName: String?,
    val sourceUrl: String?,
    val spoonacularScore: Double?,
    val spoonacularSourceUrl: String?,
    val summary: String?,
    val sustainable: Boolean?,
    val title: String?,
    val vegan: Boolean?,
    val vegetarian: Boolean?,
    val veryHealthy: Boolean?,
    val veryPopular: Boolean?,
    val weightWatcherSmartPoints: Int?,
    val whole30: Boolean?,
    val winePairing: WinePairingDataSource?
)