package com.example.foodapp.data.data_source.random_recipe_data_source

import com.google.gson.annotations.SerializedName

data class MeasuresDataSource(
    @SerializedName("metric")
    val metricDataSource: MetricDataSource?,
    @SerializedName("us")
    val usDataSource: UsDataSource?
)