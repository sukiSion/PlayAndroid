package com.sion.playandroid.ui.view.Lce

import android.widget.ProgressBar
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.sion.playandroid.R

@Composable
fun LoadingContent(modifier: Modifier = Modifier){

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {

        AndroidView(factory = { ProgressBar(it) },
            modifier = Modifier
                .width(200.dp)
                .height(110.dp),
        update = {

            it.indeterminateDrawable = AppCompatResources.getDrawable(context,
            R.drawable.loading_animation)

        })
    }

}