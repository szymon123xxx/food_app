package com.example.foodapp.data.data_source.endpoints

import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {

    @GET("recipes/random")
    suspend fun currentWeather(
        @Query("key") key: String,
        @Query("limitLicense") location: String,
        @Query("number") number: String
    ): CurrentWeatherDataSource
}