package com.example.audio.network

import android.webkit.WebSettings
import androidx.constraintlayout.solver.state.State
import com.example.audio.base.AudioApplication
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


object ServiceCreator {
    private const val BASE_URL="http://182.254.233.54:4000/"
    private val retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(getOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> create(serviceClass: Class<T>) : T= retrofit.create(serviceClass)
    inline fun <reified T> create() : T= create(T::class.java)
    private fun getOkHttpClient(): OkHttpClient? {
        return OkHttpClient.Builder()
            .addInterceptor(object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response {
                    val request: Request = chain.request()
                        .newBuilder()
                        .removeHeader("User-Agent") //移除旧的
                        .addHeader(
                            "User-Agent",
                            WebSettings.getDefaultUserAgent(AudioApplication.context)
                        ) //添加真正的头部
                        .build()
                    return chain.proceed(request)
                }
            }).build()
    }

}