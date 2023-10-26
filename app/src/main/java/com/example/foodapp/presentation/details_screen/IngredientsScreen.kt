package com.example.foodapp.presentation.details_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.foodapp.databinding.ScreenIngredientsBinding
import com.example.foodapp.presentation.adapters.IngredientsScreenAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IngredientsScreen: Fragment() {

    private val viewModel: DetailsScreenViewModel by activityViewModels()
    private var _binding: ScreenIngredientsBinding? = null
    private val binding get() = _binding!!
    private val contentAdapter = IngredientsScreenAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenIngredientsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.ingredientsScreenState.observe(viewLifecycleOwner) {
            contentAdapter.setData(it.extendedIngredients)
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
}