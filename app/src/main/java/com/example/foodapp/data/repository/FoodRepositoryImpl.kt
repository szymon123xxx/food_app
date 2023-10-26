package com.example.foodapp.data.repository

import com.example.foodapp.data.data_source.id_recipe_data_source.IdRecipeDataSource
import com.example.foodapp.data.data_source.random_recipe_data_source.RandomRecipeDataSource
import com.example.foodapp.data.endpoints.FoodApi
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
            number = number,
        )
    }

    override suspend fun getRecipeInformation(id: String): IdRecipeDataSource {
        return foodApi.getRecipeInformationEndPoint(
            id = id,
            key = Constants.API_KEY,
            includeNutrition = "true",
        )
    }
}