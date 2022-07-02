package com.sion.playandroid.logic.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import java.time.Duration

object Toast {

    fun showToast(context: Context,text:String,duration: Int = Toast.LENGTH_SHORT){

        Toast.makeText(context,text,duration).show()

    }

    fun showToast(context: Context,stringRes: Int,duration: Int = Toast.LENGTH_SHORT){

        Toast.makeText(context,stringRes,duration).show()

    }


}