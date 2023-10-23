package com.example.foodapp.presentation.details_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.domain.use_case.GetRecipeByIdUseCase
import com.example.foodapp.presentation.recipes_screen.RecipesScreenViewModel
import com.example.foodapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val getRecipeByIdUseCase: GetRecipeByIdUseCase,
): ViewModel() {

    private val _detailsScreenState = MutableLiveData<DetailsScreenState>()
    val detailsScreenState= _detailsScreenState

    private val _ingredientsScreenState = MutableLiveData<IngredientsScreenState>()
    val ingredientsScreenState= _ingredientsScreenState

    private val _descriptionScreenState = MutableLiveData<DescriptionScreenState>()
    val descriptionScreenState= _descriptionScreenState


    fun getRecipeById(id: String) {
        getRecipeByIdUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _detailsScreenState.value = DetailsScreenState(
                        title = result.data?.title,
                        image = result.data?.image
                    )
                    _ingredientsScreenState.value = IngredientsScreenState(
                        extendedIngredients = result.data?.extendedIngredients
                    )
                    _descriptionScreenState.value = DescriptionScreenState(
                        instructions = result.data?.instructions,
                        summary = result.data?.summary,
                        winePairing = result.data?.winePairing
                    )
                }

                is Resource.Loading -> {
                    _detailsScreenState.value = DetailsScreenState(isLoading = true)
                }

                is Resource.Error -> {
                    _detailsScreenState.value = DetailsScreenState(
                        error = result.message
                            ?: "Unexpected error ${RecipesScreenViewModel::class.java}"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}