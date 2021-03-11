package com.surkhojb.dindinntest.ui.products

import com.surkhojb.dindinntest.data.FoodRepository
import com.surkhojb.dindinntest.data.mapper.toModel
import com.surkhojb.dindinntest.data.remote.model.FoodDTO
import com.surkhojb.dindinntest.ui.common.DisposableViewModel
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ProductViewModel(
    private val foodRepository: FoodRepository): DisposableViewModel() {

    fun fetchProducts(){
       foodRepository.fetchPizza()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(object: SingleObserver<List<FoodDTO>>{
                override fun onSubscribe(d: Disposable?) {
                    addDisposable(d)
                }

                override fun onSuccess(list: List<FoodDTO>?) {
                    val products = list?.map {it.toModel()}
                }

                override fun onError(e: Throwable?) {

                }

            })
    }
}