package com.sion.playandroid.ui.page.article

import android.content.Context
import android.content.Intent
import com.sion.playandroid.R

fun sharePost(title:String?,post:String?,context: Context){

    if(title == null || post == null){

        return

    }


    val intent = Intent(Intent.ACTION_SEND).apply {

        type = "text/plain"

        putExtra(Intent.EXTRA_TITLE,title)

        putExtra(Intent.EXTRA_TEXT,post)

    }

    context.startActivity(

        Intent.createChooser(

            intent,

            context.getString(R.string.share_article)

        )

    )


}