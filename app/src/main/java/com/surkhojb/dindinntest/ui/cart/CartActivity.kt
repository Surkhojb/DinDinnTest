package com.surkhojb.dindinntest.ui.cart

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.surkhojb.dindinntest.databinding.ActivityCartBinding
import com.surkhojb.dindinntest.model.FoodItem
import com.surkhojb.dindinntest.ui.common.BaseActivity
import com.surkhojb.dindinntest.ui.common.UIResult
import com.surkhojb.dindinntest.utils.showError
import com.surkhojb.dindinntest.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@Suppress("UNCHECKED_CAST")
@AndroidEntryPoint
class CartActivity : BaseActivity<ActivityCartBinding>() {
    override fun getActivityBinding() = ActivityCartBinding.inflate(layoutInflater)

    private val viewModel: CartViewModel by viewModels()
    private val cartAdapter: CartAdapter by lazy { CartAdapter() }
    private var cartAmount = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView()
        observeViewModel()
    }

    private fun setUpView() {
        binding!!.cartList.layoutManager = LinearLayoutManager(this)
        binding!!.cartList.adapter = cartAdapter
        binding!!.fabPayment.setOnClickListener {
            //Open payment fragment
            val paymentFragment: CardPaymentFragment =
                CardPaymentFragment.newInstance()
            paymentFragment.arguments = Bundle().apply {
                putString("payment_amount",cartAmount.toString())
            }
            paymentFragment.show(
                supportFragmentManager,
                "paymentFragment"
            )
        }
    }

    private fun observeViewModel() {
        viewModel.cart.observe(this, Observer {
            when (it) {
                is UIResult.Loading -> {
                    binding!!.cartLoadingIndicator.visible(true)
                    binding!!.cartList.visible(false)

                }
                is UIResult.Success<*> -> {
                    binding!!.cartLoadingIndicator.visible(false)
                    binding!!.cartList.visible(true)
                    cartAdapter.refreshList(it.content as List<FoodItem>)
                    cartAmount = it.content.sumByDouble { it.price }
                }

                is UIResult.Error -> {
                    binding!!.cartLoadingIndicator.visible(false)
                    this.showError(binding!!.root,it.errorMessage)
                }
            }
        })
    }
}