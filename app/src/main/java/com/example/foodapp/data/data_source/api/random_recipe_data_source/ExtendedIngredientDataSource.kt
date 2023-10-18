package com.example.foodapp.data.data_source.api.random_recipe_data_source

import com.google.gson.annotations.SerializedName

data class ExtendedIngredientDataSource(
    val aisle: String?,
    val amount: Double?,
    val consistency: String?,
    val id: Int?,
    val image: String?,
    @SerializedName("measures")
    val measuresDataSource: MeasuresDataSource?,
    val meta: List<String?>,
    val name: String?,
    val nameClean: String?,
    val original: String?,
    val originalName: String?,
    val unit: String?
)