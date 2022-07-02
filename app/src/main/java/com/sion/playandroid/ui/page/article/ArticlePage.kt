package com.sion.playandroid.ui.page.article

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.sion.playandroid.logic.model.ArticleModel
import com.sion.playandroid.logic.utils.getHtmlText
import com.sion.playandroid.ui.view.PlayAppBar
import com.sion.playandroid.ui.view.rememberWebViewWithLifecycle
import java.lang.Exception

@SuppressLint("SetJavaScriptEnabled","UnusedMaterialScaffoldPaddingParameter")
@ExperimentalStdlibApi
@Composable
fun ArticlePage(article:ArticleModel? , onBack:()->Unit){

    val  context = LocalContext.current

    val webView = rememberWebViewWithLifecycle()

    Scaffold(topBar = {

        PlayAppBar(

            title = getHtmlText(article?.title?:"文章详情"),

            click = {

                if(webView.canGoBack()){

                    webView.goBack()

                }else{

                    onBack.invoke()

                }

            },

            showRight = true,

            rightImg = Icons.Filled.Share,

            rightClick = {

                sharePost(title = article?.title,

                    post = article?.link,

                    context = context

                )

            }

        )

    }

    ) {

        AndroidView(factory = {

            webView

        },

           modifier = Modifier.fillMaxSize()

            ){

            view ->

            view.webViewClient = object :WebViewClient(){

                override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {

                    return try {

                        if (url.startsWith("http:") || url.startsWith("https:")) {

                            view!!.loadUrl(url)

                        } else {

                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                            webView.context.startActivities(arrayOf(intent))

                        }

                        true

                    } catch (e: Exception) {

                        false

                    }

                }

            }

            val settings: WebSettings = view.settings

            settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

            settings.javaScriptEnabled = true //启用js

            settings.blockNetworkImage = false //解决图片不显示

            view.loadUrl(article?.link ?: "")

        }


    }

}