package com.example.elmenustask.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.elmenustask.databinding.ItemTagsBinding

class ProductTagsRecyclerAdapter(
    private val tagsList: ArrayList<String>,
) : RecyclerView.Adapter<ProductTagsRecyclerAdapter.ProductTagsViewHolder>() {

    override fun getItemCount() = tagsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductTagsViewHolder(
        ItemTagsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ProductTagsViewHolder, position: Int) =
        holder.bind(tagsList[position])


    class ProductTagsViewHolder(
        private val binding: ItemTagsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            data: String,
        ) {

            binding.tagTv.text = data

        }
    }
}