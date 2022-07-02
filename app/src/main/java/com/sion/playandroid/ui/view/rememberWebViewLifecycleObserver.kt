package com.sion.playandroid.ui.view

import android.util.Log
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun rememberWebViewLifecycleObserver(webView: WebView):LifecycleEventObserver =

    remember(webView){

        LifecycleEventObserver { _, event ->

            when(event){

                Lifecycle.Event.ON_RESUME -> webView.onResume()

                Lifecycle.Event.ON_PAUSE -> webView.onPause()

                Lifecycle.Event.ON_DESTROY -> webView.destroy()

                else -> Log.e("WebView",event.name)

            }

        }

    }
