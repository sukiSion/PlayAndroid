package com.sion.playandroid.logic.network.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {

    private const val BASE_URL = "https://www.wanandroid.com/"

    // 首先生成一个构建器
    private val retrofit = Retrofit.Builder().apply {

        baseUrl(BASE_URL)

        addConverterFactory(GsonConverterFactory.create())

    }.build()

    fun <T> create(service: Class<T>) = retrofit.create(service)

    inline fun <reified T> create() = create(T::class.java)



}