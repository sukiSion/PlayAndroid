package com.sion.playandroid.logic.network.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.sion.playandroid.logic.base.HomePageSource
import com.sion.playandroid.logic.model.*
import com.sion.playandroid.logic.network.PlayAndroidNetWork

class HomeArticlePagingRepository:BaseArticlePagingRepository() {

    @ExperimentalStdlibApi
    override fun getPagingData(query: com.sion.playandroid.logic.model.Query)= Pager(

        PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = true)
    ){

        // 从源码中可以看出，这里的尾调函数需要返回一个PagingSource
        // 故我们需要写一个HomePageSource继承自PagingSource

        HomePageSource()

    }.flow

    suspend fun getBanner(state:MutableLiveData<PlayState>){

        state.postValue(PlayLoading)

        val bannerResponse = PlayAndroidNetWork.getBanner()

        // 这里表示数据申请成功
        if(bannerResponse.errorCode == 0){

            val bannerList = bannerResponse.data

            bannerList.forEach {

                it.data = it.imagePath

            }

            state.postValue(PlaySuccess(bannerList))

        }else{

            state.postValue(PlayErroe(RuntimeException("response status is ${bannerResponse.errorCode}" +
                    " msg is ${bannerResponse.errorMsg}")))

        }

    }

}