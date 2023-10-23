package com.example.foodapp.domain.repository

import com.example.foodapp.data.data_source.api.id_recipe_data_source.IdRecipeDataSource
import com.example.foodapp.data.data_source.api.random_recipe_data_source.RandomRecipeDataSource
import retrofit2.http.Query

interface FoodRepository {
    suspend fun getRandomRecipe(
        @Query("number") number: String,
    ): RandomRecipeDataSource

    suspend fun getRecipeInformation(
        @Query("id") id: String,
    ): IdRecipeDataSource
}