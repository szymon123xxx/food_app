package com.example.foodapp.domain.use_case

import retrofit2.HttpException
import com.example.foodapp.data.repository.FoodRepositoryImpl
import com.example.foodapp.domain.model.random_recipe.RandomRecipe
import com.example.foodapp.domain.model.random_recipe.toRandomRecipe
import com.example.foodapp.utils.Resource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetRandomRecipeUseCase @Inject constructor(
    private val foodRepositoryImpl: FoodRepositoryImpl
) {
    operator fun invoke(): Flow<Resource<RandomRecipe>> = flow {
        try {
            emit(Resource.Loading())
            val randomRecipe =
                foodRepositoryImpl.getRandomRecipe(RECIPE_NUMBER).toRandomRecipe()
            emit(Resource.Success(randomRecipe))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: HTTP_ERROR))
        } catch (e: IOException) {
            emit(Resource.Error(IO_ERROR))
        }
    }

    companion object {
        private const val RECIPE_NUMBER = "2"
        const val HTTP_ERROR = "Unexpected http error"
        const val IO_ERROR = "Couldn't reach the server, check your internet connection!"
    }
}