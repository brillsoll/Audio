package com.example.audio.network


import com.example.audio.model.SongRespose
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface SongListService {
    @GET("/personalized")
    fun getSongList(@Query("limit") limit: String): Call<SongRespose>
}