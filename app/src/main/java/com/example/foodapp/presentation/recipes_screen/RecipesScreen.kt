package com.example.foodapp.presentation.recipes_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.foodapp.databinding.ScreenRecipesBinding
import com.example.foodapp.presentation.adapters.RecipesScreenAdapter
import com.example.foodapp.presentation.home_screen.HomeScreenDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipesScreen: Fragment(), RecipesScreenAdapter.RecipeAdapterItemListener {

    private var _binding: ScreenRecipesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RecipesScreenViewModel by viewModels()
    private val contentAdapter = RecipesScreenAdapter(this)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenRecipesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.state.observe(viewLifecycleOwner) {
            with(binding) {
                if (it.isLoading) {
                    progressBar.isVisible
                    error.isGone
                } else if (it.error.isNotEmpty()) {
                    progressBar.isGone
                    error.isVisible
                    error.text = it.error
                } else {
                    error.isGone
                    progressBar.isGone
                    contentAdapter.setData(it.data?.recipes)
                }
            }
        }
    }

    private fun setupRecyclerView() = with(binding.recyclerView) {
        setHasFixedSize(true)
        adapter = contentAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClicked(recipeId: String) {
        findNavController().navigate(
            HomeScreenDirections.actionHomeScreenToDetailsScreen(recipeId)
        )
    }
}