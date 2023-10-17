package com.example.foodapp.data.data_source.repository

import com.example.foodapp.data.data_source.endpoints.FoodApi
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodApi: FoodApi
) {
}