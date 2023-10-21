package com.example.foodapp.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.foodapp.presentation.home_screen.HomeScreen
import com.example.foodapp.presentation.recipes_screen.RecipesScreen

private const val TABS_NUMBER = 2

class HomeScreenAdapter(supportFragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(supportFragmentManager, lifecycle) {
    override fun getItemCount(): Int = TABS_NUMBER

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> RecipesScreen()
        1 -> RecipesScreen()
        else -> HomeScreen()
    }
}