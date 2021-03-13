package com.surkhojb.dindinntest.ui.products.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayoutMediator
import com.surkhojb.dindinntest.databinding.ActivityProductBinding
import com.surkhojb.dindinntest.model.BannerItem
import com.surkhojb.dindinntest.ui.banner.BannerAdapter
import com.surkhojb.dindinntest.ui.cart.CartActivity
import com.surkhojb.dindinntest.ui.common.BaseActivity
import com.surkhojb.dindinntest.ui.common.UIResult
import com.surkhojb.dindinntest.ui.products.drink.DrinkFragment
import com.surkhojb.dindinntest.ui.products.pizza.PizzaFragment
import com.surkhojb.dindinntest.ui.products.pizza.SushiFragment
import com.surkhojb.dindinntest.utils.navigateTo
import com.surkhojb.dindinntest.utils.showError
import dagger.hilt.android.AndroidEntryPoint
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

@Suppress("UNCHECKED_CAST")
@AndroidEntryPoint
class ProductActivity : BaseActivity<ActivityProductBinding>() {
    private val tabTitles = arrayOf("Pizza","Sushi","Drink")

    override fun getActivityBinding() = ActivityProductBinding.inflate(layoutInflater)

    private val viewModel: ProductViewModel by viewModels()
    private val bannerAdapter: BannerAdapter by lazy { BannerAdapter() }

    @Subscribe
    fun onAddToCartEvent(productEvent: ProductEvent){
        binding!!.fabShoppingCart.increase()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView()
        setUpFragments()
        observeViewModel()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    private fun setUpView() {
        binding!!.bannerContainer.adapter = bannerAdapter
        binding!!.fabShoppingCart.setOnClickListener {
            if (binding!!.fabShoppingCart.count > 0)
                this.navigateTo(CartActivity::class)
            else
                this.showError(binding!!.root,"You must to add at least one product.")
        }
    }

    private fun setUpFragments(){
        binding!!.productContainer.adapter = ProductAdapter(this,listOf(PizzaFragment(),SushiFragment(), DrinkFragment()))
        TabLayoutMediator(binding!!.tabProducts,binding!!.productContainer){ tab, position ->
            tab.text = tabTitles[position]
            binding!!.productContainer.setCurrentItem(tab.position, true)
        }.attach()
    }

    private fun observeViewModel() {
        viewModel.banners.observe(this, Observer {
            when (it) {
                is UIResult.Success<*> -> {
                    bannerAdapter.addBanners(it.content as List<BannerItem>)
                }

                is UIResult.Error -> {
                    this.showError(binding!!.root,it.errorMessage)
                }
            }
        })
    }
}