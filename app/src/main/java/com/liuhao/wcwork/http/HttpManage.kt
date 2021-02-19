package com.liuhao.wcwork.http


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class HttpManage private constructor() {

    private lateinit var mHttpService: HttpService


    private lateinit var mRetrofit: Retrofit

    init {
        createRetrofit()
    }

    companion object {

        val instance: HttpManage by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            HttpManage()
        }
    }


    private fun createRetrofit() {

        val builder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(loggingInterceptor)
        mRetrofit = Retrofit.Builder()
            .baseUrl("http://thoughtworks-ios.herokuapp.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(builder.build())
            .build()

        mHttpService = mRetrofit.create(HttpService::class.java)
    }


    fun getHttpService(): HttpService = mHttpService

}



