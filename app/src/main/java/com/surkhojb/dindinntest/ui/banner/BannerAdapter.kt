package com.surkhojb.dindinntest.ui.banner

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.surkhojb.dindinntest.R
import com.surkhojb.dindinntest.model.BannerItem
import com.surkhojb.dindinntest.utils.inflate

class BannerAdapter: RecyclerView.Adapter<BannerViewHolder>(){
    private val bannerItems: MutableList<BannerItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = parent.inflate(R.layout.banner_item)
        return BannerViewHolder(view)
    }

    override fun getItemCount() = bannerItems.size

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(bannerItems[position])
    }

    fun addBanners(banners: List<BannerItem>){
        bannerItems.addAll(banners)
        notifyDataSetChanged()
    }
}
