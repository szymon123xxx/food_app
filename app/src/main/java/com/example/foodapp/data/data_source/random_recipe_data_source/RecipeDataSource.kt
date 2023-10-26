package com.example.foodapp.data.data_source.random_recipe_data_source

import com.google.gson.annotations.SerializedName

data class RecipeDataSource(
    val aggregateLikes: Int?,
    @SerializedName("analyzedInstruction")
    val analyzedInstructionDataSources: List<AnalyzedInstructionDataSource?>,
    val cheap: Boolean?,
    val cookingMinutes: Int?,
    val creditsText: String?,
    val cuisines: List<Any?>,
    val dairyFree: Boolean?,
    val diets: List<String?>,
    val dishTypes: List<String?>,
    @SerializedName("extendedIngredient")
    val extendedIngredientDataSources: List<ExtendedIngredientDataSource?>,
    val gaps: String?,
    val glutenFree: Boolean?,
    val healthScore: Int?,
    val id: Int?,
    val image: String?,
    val imageType: String?,
    val instructions: String?,
    val lowFodmap: Boolean?,
    val occasions: List<String?>,
    val originalId: Any?,
    val preparationMinutes: Int?,
    val pricePerServing: Double?,
    val readyInMinutes: Int?,
    val servings: Int?,
    val sourceName: String?,
    val sourceUrl: String?,
    val spoonacularSourceUrl: String?,
    val summary: String?,
    val sustainable: Boolean?,
    val title: String?,
    val vegan: Boolean?,
    val vegetarian: Boolean?,
    val veryHealthy: Boolean?,
    val veryPopular: Boolean?,
    val weightWatcherSmartPoints: Int?
)