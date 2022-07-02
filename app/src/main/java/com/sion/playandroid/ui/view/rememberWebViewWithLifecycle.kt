package com.sion.playandroid.ui.view

import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner

@Composable
fun rememberWebViewWithLifecycle():WebView {

    val context = LocalContext.current

    val webView = remember {

        WebView(context)

    }

    val lifeObservable = rememberWebViewLifecycleObserver(webView)

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    DisposableEffect(lifecycle) {

        lifecycle.addObserver(lifeObservable)

        onDispose {

            lifecycle.removeObserver(lifeObservable)

        }

    }

    return webView

}