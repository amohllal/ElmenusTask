package com.example.elmenustask.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.AnnouncementDetails
import com.example.elmenustask.core.showImage
import com.example.elmenustask.databinding.ItemAnnouncementPagerBinding

class AnnouncementPagerAdapter(private val items: ArrayList<AnnouncementDetails>) :
    RecyclerView.Adapter<AnnouncementPagerAdapter.AnnouncementPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AnnouncementPagerViewHolder(
            ItemAnnouncementPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: AnnouncementPagerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class AnnouncementPagerViewHolder(
        private val binding: ItemAnnouncementPagerBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            data: AnnouncementDetails
        ) {

            binding.apply {
                announcementIv.showImage(data.strThumb)
            }
        }
    }
}