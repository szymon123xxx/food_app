package com.example.foodapp.data.data_source.api.random_recipe_data_source

import com.google.gson.annotations.SerializedName

data class StepDataSource(
    @SerializedName("equipment")
    val equipmentDataSources: List<EquipmentDataSource?>,
    @SerializedName("ingredient")
    val ingredientDataSources: List<IngredientDataSource?>,
    val number: Int?,
    val step: String?
)