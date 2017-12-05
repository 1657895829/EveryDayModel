package com.app.rxjava_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RxJava2 一种使用Java语言实现的 响应式编程（一种基于异步数据流概念的编程模式），来创建基于事件的异步程序。
 * Observer    观察者   （下游）
 * Observable：被观察者（上游）
 * subscribe() 订阅者（桥梁）
 * 所属包  io.reactivex
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //简单测试三者关系
                onObserverable();

                //rxjava 和retrofit 结合使用
                //rxjavaRetrofit();
            }
        });
    }

        public void onObserverable(){
            //创建一个被观察者,返回值类型为string
            Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> e) throws Exception {
                    /**
                     * ObservableEmitter   发射器
                     */

                    //发送onNext事件
                    e.onNext(""+1);
/*                for (int i=0;i<100;i++){

                }*/
                }
            });

            //创建观察者
            Observer observer = new Observer<String>() {
                @Override
                public void onSubscribe(Disposable d) { //被观察者和观察者之间的关系断开时调用
                    // 判断 被观察者和观察者 之间是否还存在订阅关系
//                disposable.isDisposed()

                    // 断开时 被观察者和观察者之间的关系
//                disposable.dispose();
                }

                @Override
                public void onNext(String s) {   //用于接受  被观察者onNext方法的事件
                    System.out.println("观察者Observer 接收onNext = " + s);
                }

                @Override
                public void onError(Throwable e) {  //数据发生异常时触发此事件
                    System.out.println("异常 onError = " + e.getMessage());
                }

                @Override
                public void onComplete() {  //事件完成时调用
                    System.out.println("事件完成：onComplete");
                }
            };

            //订阅 观察者与被观察者 ，使2者产生关系
            observable.subscribe(observer);
        }



































    //rxjava 和retrofit 结合使用
    public void rxjavaRetrofit(){
        //构建Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://m.yunifang.com")
                .addConverterFactory(GsonConverterFactory.create())
                // call 转化成 Observerable
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //实例化接口
        GetDataInterface request = retrofit.create(GetDataInterface.class);
        //发起异步请求
        request.getdData()
                // 指定 被观察者 在一个IO线程（Schedulers所在包：io.reactivex.schedulers.Schedulers）
                .subscribeOn(Schedulers.io())
                //指定观察者所在 线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bean>() {
                    @Override
                    public void accept(Bean bean) throws Exception {
                        System.out.println("获取数据：bean = " + bean.toString());
                    }
                });

    }
}
