package com.surkhojb.dindinntest.ui.products.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.surkhojb.dindinntest.data.remote.BannerRepository
import com.surkhojb.dindinntest.model.BannerItem
import com.surkhojb.dindinntest.ui.common.UIResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val bannerRepository: BannerRepository) : ViewModel() {

    private val _banners = MutableLiveData<UIResult>()
    val banners: LiveData<UIResult>
        get() = _banners

    init {
        fetchBanners()
    }

    private fun fetchBanners(){

        bannerRepository.fetchBanner()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: SingleObserver<List<BannerItem>>{
                override fun onSuccess(list: List<BannerItem>?) {
                  _banners.value = UIResult.Success(list ?: emptyList())
                }

                override fun onSubscribe(d: Disposable?) {

                }

                override fun onError(e: Throwable?) {
                    _banners.value = UIResult.Error(e?.localizedMessage ?: "Error fetching banners")
                }

            })
    }
}