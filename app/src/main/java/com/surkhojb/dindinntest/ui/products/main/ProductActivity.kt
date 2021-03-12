package com.surkhojb.dindinntest.ui.products.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayoutMediator
import com.surkhojb.dindinntest.databinding.ActivityProductBinding
import com.surkhojb.dindinntest.model.BannerItem
import com.surkhojb.dindinntest.ui.banner.BannerAdapter
import com.surkhojb.dindinntest.ui.common.BaseActivity
import com.surkhojb.dindinntest.ui.common.UIResult
import com.surkhojb.dindinntest.ui.products.pizza.PizzaFragment
import com.surkhojb.dindinntest.ui.products.pizza.SushiFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductActivity : BaseActivity<ActivityProductBinding>() {
    private val tabTitles = arrayOf("Pizza","Sushi")

    override fun getActivityBinding() = ActivityProductBinding.inflate(layoutInflater)

    private val viewModel: ProductViewModel by viewModels()
    private val bannerAdapter: BannerAdapter by lazy { BannerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpFragments()
        binding!!.bannerContainer.adapter = bannerAdapter
        viewModel.banners.observe(this, Observer {
            when(it){
                is UIResult.Success<*> -> {
                    bannerAdapter.addBanners(it.content as List<BannerItem>)
                }
            }
        })
    }

    private fun setUpFragments(){
        binding!!.productContainer.adapter = ProductAdapter(this,listOf(PizzaFragment(),SushiFragment()))
        TabLayoutMediator(binding!!.tabProducts,binding!!.productContainer){ tab, position ->
            tab.text = tabTitles[position]
            binding!!.productContainer.setCurrentItem(tab.position, true)
        }.attach()
    }
}

/**
 * TODO:
 * - Add bage to fab button
 * - Add room database to create shopping cart
 * - Create Cart activity
 * - Create indicator for viewpager
 */