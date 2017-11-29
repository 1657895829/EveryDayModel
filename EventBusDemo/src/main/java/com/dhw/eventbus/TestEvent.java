package com.dhw.eventbus;

/**
 事件发布者和订阅者如何对应上

 可以看到发布事件和订阅事件，都需要传入一个实参，而且在post方法中我们也看到了，这个实参是对象类型的，
 大家猜想的话也可以知道，发布和订阅事件是通过一个对象实参来进行关联的。

 */

public class TestEvent {
    private int mMsg;
    public TestEvent(int msg) {
        mMsg = msg;
    }
    public int getMsg(){
        return mMsg;
    }
}
