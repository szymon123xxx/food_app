package com.example.foodapp.domain.use_case

import retrofit2.HttpException
import com.example.foodapp.data.data_source.repository.FoodRepositoryImpl
import com.example.foodapp.domain.model.random_recepie.RandomRecipe
import com.example.foodapp.domain.model.random_recepie.toRandomRecipe
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import java.io.IOException

class GetRandomRecipeUseCase @Inject constructor(
    private val foodRepositoryImpl: FoodRepositoryImpl
) {
    operator fun invoke(): Flow<RandomRecipe> = flow {
        try {
            val randomRecipe =
                foodRepositoryImpl.getRandomRecipe(RECIPE_NUMBER).toRandomRecipe().recipes
            emit(RandomRecipe(randomRecipe))
            Timber.d("ELOELO $foodRepositoryImpl")
        } catch (e: HttpException) {

        } catch (e: IOException) {

        }
    }

    companion object {
        private const val RECIPE_NUMBER = "1"
    }
}