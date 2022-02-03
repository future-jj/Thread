package com.zjj.thread.concurrency;

import java.util.concurrent.ThreadFactory;


//ThreadFactory的作用，我们需要对线程池中的线程对象赋予统一的线程优先级，统一的名称，甚至是统一的业务处理或者是统一的业务方面的初始化工作
public class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this+"创建新的线程 ");
        Thread t=new Thread(r);
        System.out.println("创建"+t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh="+t.getUncaughtExceptionHandler());
        return t;
    }
}
