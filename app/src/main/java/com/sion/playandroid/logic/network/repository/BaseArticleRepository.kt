package com.sion.playandroid.logic.network.repository

import android.accounts.NetworkErrorException
import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.sion.playandroid.R
import com.sion.playandroid.logic.model.*
import com.sion.playandroid.logic.network.PlayAndroidNetWork
import com.sion.playandroid.logic.utils.NetworkUtils
import com.sion.playandroid.logic.utils.Toast

abstract class BaseArticleRepository(private val application: Application) : BaseArticlePagingRepository() {

    /**
     *
     * 获取标题列表
     *
     */
    suspend fun getTree(state: MutableLiveData<PlayState>){

        state.postValue(PlayLoading)

        if(!NetworkUtils.isConnected(application)){

            Toast.showToast(application, R.string.no_network)

            state.postValue(PlayErroe(NetworkErrorException(application.getString(R.string.no_network))))

            return
        }

        val tree = getArticleTree()

        if(tree.errorCode == 0){

            val projectList = tree.data

            state.postValue(PlaySuccess(projectList))

        }else{

            state.postValue(PlayErroe(NetworkErrorException(application.getString(R.string.no_network))))

        }

    }

    abstract suspend fun getArticleTree() :BaseModel<List<ClassifyModel>>

}