package com.sion.playandroid.logic.utils

import android.os.Build
import android.text.Html

/**
 *
 * 将Html文本转为普通字符串
 *
 * @param text html字符串
 *
 *
 */

fun getHtmlText(text:String) =

    // 大于android7
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){

        Html.fromHtml(text,Html.FROM_HTML_MODE_LEGACY).toString()

    }else{

        text

    }