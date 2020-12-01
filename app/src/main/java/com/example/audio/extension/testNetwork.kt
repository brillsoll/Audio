package com.example.audio.extension

import okhttp3.OkHttpClient
import okhttp3.Request


    fun main() {
        val address =
            "http://tingapi.ting.baidu.com/v1/restserver/ting?size=2&type=2&method=baidu.ting.billboard.billList"
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(address)
            .build()
        val response = client.newCall(request).execute()
        val responseData = response.body()?.string()
        System.out.println(responseData)

    }
