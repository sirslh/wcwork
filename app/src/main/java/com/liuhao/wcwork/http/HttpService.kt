package com.liuhao.wcwork.http

import io.reactivex.Observable
import retrofit2.http.GET


interface HttpService {


    @GET("user/jsmith")
    fun getUserVO(): Observable<UserVO>


    @GET("user/jsmith/tweets")
    fun getTweetsVo(): Observable<List<TweetsVo>>
}