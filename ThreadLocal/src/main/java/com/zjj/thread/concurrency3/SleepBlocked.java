package com.zjj.thread.concurrency3;

/**
 * @Author mi
 * @create 2022/2/7 1:11
 * @Description 可中断阻塞
 */
public class SleepBlocked implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}
