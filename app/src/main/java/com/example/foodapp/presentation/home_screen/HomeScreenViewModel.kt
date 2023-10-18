package com.example.foodapp.presentation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.domain.use_case.GetRandomRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getRandomRecipeUseCase: GetRandomRecipeUseCase
): ViewModel() {

     fun getRandomRecipe() {
        getRandomRecipeUseCase().onEach { result ->
        }.launchIn(viewModelScope)
    }
}