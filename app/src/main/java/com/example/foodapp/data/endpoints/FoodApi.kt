package com.example.foodapp.data.endpoints

import com.example.foodapp.data.data_source.id_recipe_data_source.IdRecipeDataSource
import com.example.foodapp.data.data_source.random_recipe_data_source.RandomRecipeDataSource
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FoodApi {

    @GET("recipes/random")
    suspend fun randomRecipeEndPoint(
        @Query("apiKey") key: String,
        @Query("limitLicense") limitLicense: String,
        @Query("number") number: String,
    ): RandomRecipeDataSource

    @GET("recipes/{id}/information")
    suspend fun getRecipeInformationEndPoint(
        @Path("id") id: String,
        @Query("apiKey") key: String,
        @Query("includeNutrition") includeNutrition: String,
    ): IdRecipeDataSource
}