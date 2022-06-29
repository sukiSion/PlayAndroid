package com.sion.bannerpagetest.banner.logic.model


// BaseBannerBean只是为了抽象，为了能统一对图片做处理

/**
 * Banner Model 的基类
 */

abstract class BaseBannerBean {


    // 图片资源 可以是：url、文件路径或者是 drawable id
    abstract val data : Any?

}