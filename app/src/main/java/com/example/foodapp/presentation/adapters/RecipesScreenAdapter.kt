package com.example.foodapp.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.foodapp.databinding.ScreenRecipesItemBinding
import com.example.foodapp.domain.model.random_recepie.Recipe

class RecipesScreenAdapter(val listener: RecipeAdapterItemListener):
    RecyclerView.Adapter<RecipesScreenAdapter.ContentViewHolder>() {

    private var recipeList: MutableList<Recipe> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(recipes: List<Recipe>?) {
        recipeList = recipes?.toMutableList() ?: arrayListOf()
        notifyDataSetChanged()
    }
    inner class ContentViewHolder(private val binding: ScreenRecipesItemBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(recipe: Recipe) {
                binding.apply {
                    title.text = recipe.title
                    pricePerServing.text = recipe.pricePerServing.toString()
                    cookTime.text = recipe.readyInMinutes.toString()
                    image.load(recipe.image)
                    root.setOnClickListener { listener.onItemClicked("1") }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder =
        ContentViewHolder(
            ScreenRecipesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = recipeList.size

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) =
        holder.bind(recipeList[position])

    interface RecipeAdapterItemListener {
        fun onItemClicked(recipeId: String)
    }
}
