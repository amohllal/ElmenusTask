package com.example.elmenustask.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.ProductDetails
import com.example.elmenustask.core.showImage
import com.example.elmenustask.databinding.ItemMealsBinding

class ProductRecyclerAdapter(
    private val mealsList: ArrayList<ProductDetails>,
    private val itemClick: (ProductDetails) -> Unit

) : RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder>() {

    override fun getItemCount() = mealsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductViewHolder(
        ItemMealsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(mealsList[position], itemClick)


    class ProductViewHolder(
        private val binding: ItemMealsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            data: ProductDetails,
            onItemClicked: (ProductDetails) -> Unit
        ) {

            binding.apply {
                mealIv.showImage(data.strMealThumb)
                mealTitleTv.text = data.strMeal
                mealCategoryTitleTv.text = " ${data.strCategory}"
                mealOriginTitleTv.text = " ${data.strArea}"
                tagsRv.apply {
                    if (data.strTags.isNullOrEmpty())
                        isGone = true
                    else {
                        adapter = ProductTagsRecyclerAdapter(data.strTags!!)
                    }
                }
            }

            onItemClicked(data)

        }
    }
}