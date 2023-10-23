package com.example.foodapp.data.data_source.api.id_recipe_data_source

data class WinePairingDataSource(
    val pairedWines: List<String>,
    val pairingText: String,
    val productMatches: List<ProductMatcheDataSource>
)