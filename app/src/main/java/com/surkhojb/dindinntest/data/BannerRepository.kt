package com.surkhojb.dindinntest.data

import com.surkhojb.dindinntest.R
import com.surkhojb.dindinntest.model.BannerItem
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface BannerRepository{
    fun fetchBanner(): Single<List<BannerItem>>
}

class BannerRepositoryImpl @Inject constructor():
    BannerRepository {

    override fun fetchBanner(): Single<List<BannerItem>>{
        return Single.just(buildBanners())
    }

    private fun buildBanners() = listOf(
        BannerItem("Monday","2x1 in all our pizza selections!", R.drawable.banner_2),
        BannerItem("Friday","30% off in all our sushi dishes!", R.drawable.banner_3),
        BannerItem("Sunday","Spend 50$ and get a free desert!", R.drawable.banner_4)
    )
}