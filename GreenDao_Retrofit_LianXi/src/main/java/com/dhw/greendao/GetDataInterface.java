package com.dhw.greendao;

import com.dhw.greendao.bean.NewsBean;
import retrofit2.http.GET;

/**
 * Retrofit请求网络数据的接口
 * http://api.tianapi.com/wxnew/?key=18e883dd6b316eb1d97fd86338abbf06&num=10
 */
public interface GetDataInterface {
    //get请求方式,部分url接口
    @GET("/wxnew/?key=18e883dd6b316eb1d97fd86338abbf06&num=10")
    retrofit2.Call<NewsBean> getData();
}
