package com.example.foodapp.data.data_source.endpoints

import com.example.foodapp.data.data_source.api.random_recipe_data_source.RandomRecipeDataSource
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {

    @GET("recipes/random")
    suspend fun randomRecipeEndPoint(
        @Query("apiKey") key: String,
        @Query("limitLicense") limitLicense: String,
        @Query("number") number: String
    ): RandomRecipeDataSource
}