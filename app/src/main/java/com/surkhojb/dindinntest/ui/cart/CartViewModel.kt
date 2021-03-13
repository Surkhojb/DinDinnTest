package com.surkhojb.dindinntest.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.surkhojb.dindinntest.data.OrderRepository
import com.surkhojb.dindinntest.ui.common.UIResult
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val orderRepository: OrderRepository
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    private val _cart = MutableLiveData<UIResult>()
    val cart: LiveData<UIResult>
        get() = _cart

    init {
        fetchShoppingCart()
    }

    private fun fetchShoppingCart(){

       val disposable =  orderRepository.getShoppingCart()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { list, error ->
                if(!list.isNullOrEmpty()){
                    _cart.value = UIResult.Success(list)
                }else{
                    _cart.value = UIResult.Error(error?.localizedMessage ?: "Error fetching banners")
                }
            }

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}