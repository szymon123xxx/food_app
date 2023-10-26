package com.example.foodapp.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.foodapp.presentation.details_screen.DescriptionScreen
import com.example.foodapp.presentation.details_screen.DetailsScreen
import com.example.foodapp.presentation.details_screen.IngredientsScreen

private const val TABS_NUMBER = 2
class DetailsScreenAdapter(supportFragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(supportFragmentManager, lifecycle) {
    override fun getItemCount(): Int = TABS_NUMBER

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> IngredientsScreen()
        1 -> DescriptionScreen()
        else -> DetailsScreen()
    }
}