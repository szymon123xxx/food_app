package com.example.foodapp.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.foodapp.databinding.ScreenIngredientsItemBinding
import com.example.foodapp.domain.model.id_recipe.ExtendedIngredient

class IngredientsScreenAdapter :
    RecyclerView.Adapter<IngredientsScreenAdapter.ContentViewHolder>() {

    private var ingredientsList: MutableList<ExtendedIngredient> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(ingredients: List<ExtendedIngredient>?) {
        ingredientsList = ingredients?.toMutableList() ?: arrayListOf()
        notifyDataSetChanged()
    }

    inner class ContentViewHolder(private val binding: ScreenIngredientsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: ExtendedIngredient): Unit = with(binding) {
            image.load(IMAGE_URL + recipe.image)
            description.text = recipe.original
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ContentViewHolder(
        ScreenIngredientsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = ingredientsList.size

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) =
        holder.bind(ingredientsList[position])

    companion object {
        private const val IMAGE_URL = "https://spoonacular.com/cdn/ingredients_100x100/"
    }
}