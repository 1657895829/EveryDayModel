package com.dhw.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 参考博客：https://www.cnblogs.com/upwgh/p/6394901.html
 * 一. EventBus是一款Android下的发布/订阅事件总线机制。可以代替Intent、Handler、Broadcast等在Fragment、Activity之间传递消息。

   优点：开销小，代码优雅。将发送者和接受者解耦。
        既然是有关于事件的发布和订阅，那么发布者和订阅者的关系又是怎样的呢？
        事件的发布者可以发布多个事件，发布者同时也可以是订阅者，订阅者可以订阅多个事件。
   二、实例
        接下来要通过实例来讲解如何使用EventBus了，在看代码之前要记得三个问题。
        1、事件发布者如何发布事件
        2、事件订阅者如何订阅事件
        3、订阅者如何准确接收发布者发布的多个事件中的一个(假设发布者发布多个事件，订阅者只是订阅其中的一个事件)

    使用时在gradle文件中添加EventBus的依赖      compile 'org.greenrobot:eventbus:3.0.0'

 */
public class MainActivity extends AppCompatActivity {

    public ProgressBar progressBar = null;
    public int time = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (time<100){
                            time += 15;
                            EventBus.getDefault().post(new TestEvent(time));
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(TestEvent event){
        progressBar.setProgress(event.getMsg());
    }
}
