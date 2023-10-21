package com.example.foodapp.presentation.recipes_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.domain.use_case.GetRandomRecipeUseCase
import com.example.foodapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipesScreenViewModel @Inject constructor(
    private val getRandomRecipeUseCase: GetRandomRecipeUseCase
) : ViewModel() {

    private val _state = MutableLiveData<RecipesScreenState>()
    val state= _state

    init {
        getRandomRecipe()
    }

    private fun getRandomRecipe() {
        getRandomRecipeUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = RecipesScreenState(data = result.data)
                }

                is Resource.Loading -> {
                    _state.value = RecipesScreenState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = RecipesScreenState(
                        error = result.message
                            ?: "Unexpected error ${RecipesScreenViewModel::class.java}"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}