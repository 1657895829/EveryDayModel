package com.dhw.eventbus_lianxi;

/**
 *  新建一个类FirstEvent
 *  这个类很简单，构造时传进去一个字符串，然后可以通过getMsg()获取出来。
 */

public class FirstEvent {
    private String mMsg;
    public FirstEvent(String msg) {
        //声明属性
        mMsg = msg;
    }
    public String getMsg(){
        return mMsg;
    }
}
