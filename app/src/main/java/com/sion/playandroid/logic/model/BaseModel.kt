package com.sion.playandroid.logic.model

data class BaseModel<T>(
    val `data`: T,
    val errorCode: Int,
    val errorMsg: String
)
