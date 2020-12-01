package com.example.audio.model

import com.google.gson.annotations.SerializedName

data class SongRespose(val code : Int,val result : List<Song>)
data class Song(val id:String,val name:String,val picUrl:String)
