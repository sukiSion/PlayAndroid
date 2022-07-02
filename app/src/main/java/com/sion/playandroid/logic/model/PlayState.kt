package com.sion.playandroid.logic.model

sealed class PlayState {
}


object PlayLoading :PlayState()

data class PlaySuccess< T>(val data:T) :PlayState()

data class PlayErroe(val e:Throwable):PlayState()
