package com.example.elmenustask.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.CategoryDetails
import com.example.elmenustask.core.showImage
import com.example.elmenustask.databinding.ItemTopCategoryBinding

class TopCategoryRecyclerAdapter(
    private val categoryList: ArrayList<CategoryDetails>,
    private val itemClick: (CategoryDetails) -> Unit

) : RecyclerView.Adapter<TopCategoryRecyclerAdapter.TopCategoryViewHolder>() {

    override fun getItemCount() = categoryList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TopCategoryViewHolder(
        ItemTopCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: TopCategoryViewHolder, position: Int) =
        holder.bind(categoryList[position], itemClick)


    class TopCategoryViewHolder(
        private val binding: ItemTopCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            data: CategoryDetails,
            onItemClicked: (CategoryDetails) -> Unit
        ) {

            binding.topCategoryIv.showImage(data.strCategoryThumb)
            binding.topCategoryNameTv.text = data.strCategory
            binding.root.setOnClickListener {
                onItemClicked(data)
            }

        }
    }
}