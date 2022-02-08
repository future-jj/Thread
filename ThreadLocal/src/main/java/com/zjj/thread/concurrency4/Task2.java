package com.zjj.thread.concurrency4;

/**
 * @Author mi
 * @create 2022/2/9 0:59
 */
public class Task2 implements Runnable{

    static Blocker blocker=new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
