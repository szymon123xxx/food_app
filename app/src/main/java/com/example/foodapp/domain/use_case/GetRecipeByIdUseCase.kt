package com.example.foodapp.domain.use_case

import com.example.foodapp.data.data_source.repository.FoodRepositoryImpl
import com.example.foodapp.domain.model.id_recipe.IdRecipe
import com.example.foodapp.domain.model.id_recipe.toIdRecipe
import com.example.foodapp.utils.Constants.HTTP_ERROR
import com.example.foodapp.utils.Constants.IO_ERROR
import com.example.foodapp.utils.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipeByIdUseCase @Inject constructor(
    private val foodRepositoryImpl: FoodRepositoryImpl,
) {
    operator fun invoke(id: String): Flow<Resource<IdRecipe>> = flow {
        try {
            emit(Resource.Loading())
            val idRecipe =
                foodRepositoryImpl.getRecipeInformation(id).toIdRecipe()
            emit(Resource.Success(idRecipe))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: HTTP_ERROR))
        } catch (e: IOException) {
            emit(Resource.Error(IO_ERROR))
        }
    }
}