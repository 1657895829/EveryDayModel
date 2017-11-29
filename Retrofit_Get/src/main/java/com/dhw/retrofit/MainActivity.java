package com.dhw.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 详情参考博客：http://blog.csdn.net/carson_ho/article/details/73732076
 *
Retrofit特性

 1.我们根据业务需求来进行接口的封装，
    实际开发可能会封装多个不同的java接口以满足业务需求。(注意：这里会用到Retrofit的注解：比如get,post)
 2.使用Retrofit提供的封装方法将我们的生成我们接口的实现类，这个真的很赞，不用我们自己实现，
    通过注解Retrofit全部帮我们自动生成好了。
 3.调用我们实现类对象的接口方法。
 */

/**
 * 本Model实例1：
 * ·实现功能：将中文翻译成英文
   ·实现方案：采用Get方法对 金山词霸API 发送网络请求（采用 Gson 进行数据解析）
 * ·步骤说明:
 *   步骤1：添加Retrofit库的依赖
     步骤2：创建 接收服务器返回数据 的类
     步骤3：创建 用于描述网络请求 的接口
     步骤4：创建 Retrofit 实例
     步骤5：创建 网络请求接口实例 并 配置网络请求参数
     步骤6：发送网络请求（采用最常用的异步方式）封装了 数据转换、线程切换的操作
     步骤7： 处理服务器返回的数据
 */

/**
 使用步骤1：
     1. 在 Gradle加入Retrofit库的依赖
         // Retrofit库
         compile 'com.squareup.retrofit2:retrofit:2.3.0'

         由于Retrofit是基于OkHttp，所以还需要添加OkHttp库依赖

         // Okhttp库
         compile 'com.squareup.okhttp3:okhttp:3.9.0'

     2. 在AndroidManifest.xml添加 网络权限
        <uses-permission android:name="android.permission.INTERNET"/>

 步骤2 3 在其它2个类

     步骤4：创建Retrofit对象
     步骤5：创建 网络请求接口 的实例
     步骤6：发送网络请求
     步骤7：处理返回数据
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 使用Retrofit封装的方法
        request();
    }

    public  void request() {
        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")                 // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GitHubServiceInterface request = retrofit.create(GitHubServiceInterface.class);

        //对 发送请求 进行封装
        Call<Translation> call = request.getCall();

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Translation>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                // 步骤7：处理返回的数据结果
                response.body().show();
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                System.out.println("连接失败");
            }
        });
    }
}
