package com.zjj.thread.concurrency;

public class ExceptionThread2 implements Runnable{
    @Override
    public void run() {
        Thread t=Thread.currentThread();
        System.out.println("当前运行线程是"+t);
        System.out.println("eh="+t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
