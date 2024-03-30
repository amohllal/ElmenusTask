package com.example.elmenustask.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.IngredientDetails
import com.example.elmenustask.databinding.ItemIngredientBinding

class IngredientsRecyclerAdapter(
    private val ingredientList: ArrayList<IngredientDetails>,
    private val itemClick: (IngredientDetails) -> Unit

) : RecyclerView.Adapter<IngredientsRecyclerAdapter.IngredientsViewHolder>() {

    override fun getItemCount() = ingredientList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = IngredientsViewHolder(
        ItemIngredientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) =
        holder.bind(ingredientList[position], itemClick)


    class IngredientsViewHolder(
        private val binding: ItemIngredientBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            data: IngredientDetails,
            onItemClicked: (IngredientDetails) -> Unit
        ) {
            onItemClicked(data)

        }
    }
}