package com.surkhojb.dindinntest.ui.banner

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.surkhojb.dindinntest.R
import com.surkhojb.dindinntest.model.BannerItem
import com.surkhojb.dindinntest.utils.loadImage

class BannerViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val image: ImageView = view.findViewById(R.id.image_banner)
    private val title: TextView = view.findViewById(R.id.banner_title)
    private val subtitle: TextView = view.findViewById(R.id.banner_subtitle)
    fun bind(bannerItem: BannerItem){
        image.loadImage(bannerItem.image)
        title.text = bannerItem.name
        subtitle.text = bannerItem.description
    }
}