package com.example.foodapp.presentation.details_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.foodapp.databinding.ScreenDetailsBinding
import com.example.foodapp.presentation.adapters.DetailsScreenAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsScreen: Fragment() {

    private val viewModel: DetailsScreenViewModel by activityViewModels()
    private val recipesScreenArgs: DetailsScreenArgs by navArgs()
    private var _binding: ScreenDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTabs()
        with(viewModel) {
            getRecipeById(recipesScreenArgs.recipeId)
            detailsScreenState.observe(viewLifecycleOwner) {
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
                        setContent(it)
                    }
                }
            }
        }
    }

    private fun setContent(data: DetailsScreenState) = with(binding) {
        image.load(data.image)
    }

    private fun setUpTabs() {
        val adapter = DetailsScreenAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when(position){
                0 -> {
                    tab.text = "Ingredients"
                }
                1 -> {
                    tab.text = "Preparation"
                }
                3 -> {
                    tab.text = "Similar"
                }
            }
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}