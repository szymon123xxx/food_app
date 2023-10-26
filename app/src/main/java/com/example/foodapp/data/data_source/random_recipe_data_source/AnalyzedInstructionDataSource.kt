package com.example.foodapp.data.data_source.random_recipe_data_source

import com.google.gson.annotations.SerializedName

data class AnalyzedInstructionDataSource(
    val name: String?,
    @SerializedName("step")
    val stepDataSources: List<StepDataSource?>
)