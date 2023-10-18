package com.example.foodapp.data.data_source.repository

import com.example.foodapp.data.data_source.api.random_recipe_data_source.RandomRecipeDataSource
import com.example.foodapp.data.data_source.endpoints.FoodApi
import com.example.foodapp.domain.repository.FoodRepository
import com.example.foodapp.utils.Constants
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodApi: FoodApi
) : FoodRepository {
    override suspend fun getRandomRecipe(number: String): RandomRecipeDataSource {
        return foodApi.randomRecipeEndPoint(
            key = Constants.API_KEY,
            limitLicense = "true",
            number = number
        )
    }
}