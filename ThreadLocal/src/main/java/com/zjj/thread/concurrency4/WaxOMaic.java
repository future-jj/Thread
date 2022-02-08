package com.zjj.thread.concurrency4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author mi
 * @create 2022/2/8 2:17
 * // 有两个过程：一个就是将蜡涂到Car上，一个就是抛光它。抛光任务在涂蜡任务之前，是不能执行其他工作的，而涂蜡任务在涂另一层蜡之前，必须等待
 * 抛光任务的完成
 */
public class WaxOMaic {
    // 在调用sleep的时候锁是没有释放的，而当调用wait的时候锁是已经被释放了的
    // wait和sleep的区别
    //在wait区间锁是释放的
    //可以通过notify()和notifyAll()或者令时间到期，从wait()中恢复
    //wait() notify() notifyALl()都是Object基类的一部分而不是Thread的一部分
    //不能在非同步控制的方法中调用wait()、notify()、notifyAll()
    //调用wait()和notify()和notifyAll()这些方法都必须拥有这些方法的锁

    public static void main(String[] args) throws InterruptedException {
        Car car=new Car();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new WaxOff(car));
        Thread.sleep(100);
        executorService.execute(new WaxOn(car));
        Thread.sleep(5000);
        executorService.shutdownNow();
    }

}
