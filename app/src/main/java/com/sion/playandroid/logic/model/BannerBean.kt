package com.sion.playandroid.logic.model

import com.sion.bannerpagetest.banner.logic.model.BaseBannerBean


data class BannerBean(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String,
    override var data:String?
):BaseBannerBean()