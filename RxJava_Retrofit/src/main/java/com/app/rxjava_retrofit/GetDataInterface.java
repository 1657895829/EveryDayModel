package com.app.rxjava_retrofit;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 网络接口数据的请求
 */

public interface GetDataInterface {
    //不指定返回数据的Retrofit网络请求,<>中默认写ResponseBody
    @GET("/yunifang/mobile/home")
    Call<ResponseBody> get();

    //被观察者 要倒 io.reactivex.Observable 包
    @GET("/yunifang/mobile/home")
    Observable<Bean> getdData();
}
