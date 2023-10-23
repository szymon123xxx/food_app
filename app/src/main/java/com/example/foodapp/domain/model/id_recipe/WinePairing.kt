package com.example.foodapp.domain.model.id_recipe

import com.example.foodapp.data.data_source.api.id_recipe_data_source.WinePairingDataSource

data class WinePairing (
    val pairingText: String,
)

fun WinePairingDataSource.toWinePairing(): WinePairing {
    return WinePairing(
        pairingText = pairingText,
    )
}