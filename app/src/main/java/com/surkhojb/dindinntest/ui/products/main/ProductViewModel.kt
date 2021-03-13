package com.surkhojb.dindinntest.ui.products.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.surkhojb.dindinntest.data.BannerRepository
import com.surkhojb.dindinntest.model.BannerItem
import com.surkhojb.dindinntest.ui.common.UIResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val bannerRepository: BannerRepository
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    private val _banners = MutableLiveData<UIResult>()
    val banners: LiveData<UIResult>
        get() = _banners

    init {
        fetchBanners()
    }



    private fun fetchBanners(){
        val disposable = bannerRepository.fetchBanner()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { list, error ->
                if(!list.isNullOrEmpty()){
                    _banners.value = UIResult.Success(list)
                }else{
                    _banners.value = UIResult.Error(error?.localizedMessage ?: "Error fetching banners")
                }
            }

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}