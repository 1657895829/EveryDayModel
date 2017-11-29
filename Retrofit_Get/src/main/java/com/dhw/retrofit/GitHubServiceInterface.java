package com.dhw.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 步骤3：创建 用于描述网络请求 的接口
 * Retrofit将 Http请求 抽象成 Java接口：采用 注解 描述网络请求参数 和配置网络请求参数
     1. 用 动态代理 动态 将该接口的注解“翻译”成一个 Http 请求，最后再执行 Http 请求
     2. 注：接口中的每个方法的参数都需要使用注解标注，否则会报错
 */
public interface GitHubServiceInterface {
    /**
     1.@GET注解的作用:采用Get方法发送网络请求
     2.getCall() = 接收网络请求数据的方法（自定义名称）
     3.其中返回类型为Call<*>，*是接收数据的类（即定义的Translation类）
     4.如果想直接获得Responsebody中的内容，可以定义网络请求返回值为Call<ResponseBody>
     5.Retrofit把网络请求的URL分成了两部分：一部分放在Retrofit对象里，另一部分放在网络请求接口里
     6.如果接口里的url是一个完整的网址，那么放在Retrofit对象里的URL可以忽略
     */
    // 注解里传入 网络请求 的部分URL地址
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Call<Translation> getCall();
}
