package com.sion.playandroid.ui.page.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sion.playandroid.ui.main.PlayActions
import  androidx.lifecycle.viewmodel.compose.viewModel
import com.sion.bannerpagetest.banner.ui.BannerPager
import com.sion.playandroid.R
import com.sion.playandroid.logic.model.*
import com.sion.playandroid.ui.view.Lce.LcePage
import com.sion.playandroid.ui.view.PlayAppBar

@Composable
fun HomePage(actions: PlayActions, modifier: Modifier = Modifier,viewModel:HomePageViewModel = viewModel()){

    val bannerData by viewModel.bannerState.observeAsState(PlayLoading)

    viewModel.getData()
    
    Column(modifier = Modifier.fillMaxSize()) {
        
        PlayAppBar(title = stringResource(id = R.string.home_page),
        showBack = false)


        LcePage(playState = bannerData, onErrorClick = {

            viewModel.getData()

        }){

            val data = bannerData as PlaySuccess<List<BannerBean>>

            BannerPager(items = data.data){

                actions.enterArticle(

                    ArticleModel(

                        title = it.title,
                        link = it.url
                    )

                )

            }


        }
        
    }

}