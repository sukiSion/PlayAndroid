package com.sion.playandroid.ui.view.Lce

import androidx.compose.runtime.Composable
import com.sion.playandroid.logic.model.PlayErroe
import com.sion.playandroid.logic.model.PlayLoading
import com.sion.playandroid.logic.model.PlayState
import com.sion.playandroid.logic.model.PlaySuccess


@Composable
fun LcePage(playState: PlayState,onErrorClick:() -> Unit, content :@Composable () -> Unit ){

    when(playState){

        is PlayLoading -> {

            LoadingContent()

        }

        is PlayErroe ->{

            ErrorContent {

                onErrorClick()

            }

        }

        is PlaySuccess<*> -> {

            content()

        }

    }

}