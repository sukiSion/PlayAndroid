package com.sion.playandroid.ui.main

import androidx.navigation.NavHostController
import com.sion.playandroid.R


/**
 * 跳转动画，之后Navigation如果支持转场动画的话即可生效
 *
 * @param navController /
 * @param route 跳转路径
 */
 fun toAnimView(navController: NavHostController, route: String) {
    navController.navigate(route) {
        anim {
            enter = R.anim.activity_push_in
            exit = R.anim.activity_push_out
            popEnter = R.anim.center_zoom_in
            popExit = R.anim.center_zoom_out
        }
    }
}