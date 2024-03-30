package com.example.elmenustask.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.elmenustask.R
import com.example.elmenustask.databinding.ItemDotBinding

class DotsIndicatorAdapter(private val itemCount: Int, private val viewPager: ViewPager2) :
    RecyclerView.Adapter<DotsIndicatorAdapter.DotsIndicatorAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DotsIndicatorAdapterViewHolder(
            ItemDotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: DotsIndicatorAdapterViewHolder, position: Int) {
        holder.bind(position == viewPager.currentItem)
    }

    override fun getItemCount(): Int = itemCount


    inner class DotsIndicatorAdapterViewHolder(
        private val binding: ItemDotBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(isActive: Boolean) {
            if (isActive) {
                binding.dotIv.setImageResource(R.drawable.dot_selected)
            } else {
                binding.dotIv.setImageResource(R.drawable.dot_unselected)
            }
        }
    }
}