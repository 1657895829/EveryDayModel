package com.example.viewflipper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ViewFlipper;

/**
 *   跑马灯（marquee）页面实现
 *
 *  下面是ViewFlipper常用的方法介绍，除了可以设置上面的属性之外，还提供了其他方法

     isFlipping： 判断View切换是否正在进行
     setFilpInterval：设置View之间切换的时间间隔
     startFlipping：开始View的切换，而且会循环进行
     stopFlipping：停止View的切换
     setOutAnimation：设置切换View的退出动画
     setInAnimation：设置切换View的进入动画
     showNext： 显示ViewFlipper里的下一个View
     showPrevious：显示ViewFlipper里的上一个View
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewFlipper vf = (ViewFlipper) findViewById(R.id.vf);

        vf.addView(View.inflate(this, R.layout.view_advertisement01, null));
        vf.addView(View.inflate(this, R.layout.view_advertisement02, null));
        vf.addView(View.inflate(this, R.layout.view_advertisement03, null));
    }
}
