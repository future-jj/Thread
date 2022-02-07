package com.zjj.thread.concurrency3;

/**
 * @Author mi
 * @create 2022/2/7 1:44
 * 不可中断阻塞
 */
public class SynchronizedBlocked implements Runnable{

    public synchronized void f(){
        while (true){
            // Never release lock
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread(){
            public void run(){
                f(); // Lock acquired by this thread
            }
        }.start();

    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}
