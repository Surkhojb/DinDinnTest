package com.surkhojb.dindinntest.ui.products.generic

import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding4.view.clicks
import com.surkhojb.dindinntest.R
import com.surkhojb.dindinntest.model.FoodItem
import com.surkhojb.dindinntest.utils.loadUrl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit


class GenericViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val productImage: ImageView = view.findViewById(R.id.generic_product_image)
    private val productName: TextView = view.findViewById(R.id.generic_product_name)
    private val productDescription: TextView = view.findViewById(R.id.generic_product_description)
    private val productBuy: Button = view.findViewById(R.id.generic_product_btn_buy)


    fun bind(item: FoodItem, action: (FoodItem) -> Unit){
        productImage.loadUrl(item.url)
        productName.text = item.name
        productDescription.text = item.description
        productBuy.text = "${item.price} SGD"

        productBuy.clicks()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                productBuy.setBackgroundColor(Color.GREEN)
                productBuy.text = "added +1"
                action(item)
            }
            .delay(200, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
            .subscribe {
                productBuy.setBackgroundColor(Color.BLACK)
                productBuy.text = "${item.price} SGD"
            }
    }
}