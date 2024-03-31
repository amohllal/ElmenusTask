package com.example.elmenustask.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Meals
import com.example.elmenustask.core.showImage
import com.example.elmenustask.databinding.ItemMealTopCategoryBinding

class TopMealsRecyclerAdapter(
    private val mealsList: ArrayList<Meals>,
    private val itemClick: (Meals) -> Unit

) : RecyclerView.Adapter<TopMealsRecyclerAdapter.TopMealsViewHolder>() {

    override fun getItemCount() = mealsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TopMealsViewHolder(
        ItemMealTopCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: TopMealsViewHolder, position: Int) =
        holder.bind(mealsList[position], itemClick)


    class TopMealsViewHolder(
        private val binding: ItemMealTopCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            data: Meals,
            onItemClicked: (Meals) -> Unit
        ) {

            binding.apply {
                mealIv.showImage(data.imageUrl)
                mealTitleTv.text = data.title
                root.setOnClickListener {
                    onItemClicked(data)
                }
            }

        }
    }
}