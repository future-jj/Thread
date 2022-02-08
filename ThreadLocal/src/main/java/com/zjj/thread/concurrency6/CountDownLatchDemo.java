package com.zjj.thread.concurrency6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.zjj.thread.net.mindview.util.Print.print;

/**
 * @Author mi
 * @create 2022/2/9 5:55
 */
public class CountDownLatchDemo {

    // 它被用来同步一个或者多个任务，强制他们等待由其他任务执行的一组操作
    //你可以在CountDownLatch上设置一个初始计数值，任何在这个对象上调用await()方法都将会阻塞，直到这个计数值达到0
    //其他任务在结束工作的时候可以调用countDownLatch()来减少这个数值
    //CountDownLatch被设置为只触发一次，计数值不能被重置，如果你需要能够重置计数值的版本，则可以使用CyclicBarrier

    //CountDownLatch的典型用法就是将一个程序分为n个互相可以独立解决的任务，并创建值为0的CountDownLatch
    //当每一个任务完成的时候都会在这个锁存器上调用countDown()
    static final int SIZE = 100;
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        // All must share a single CountDownLatch object:
        CountDownLatch latch = new CountDownLatch(SIZE);
        for(int i = 0; i < 10; i++)
            exec.execute(new WaitingTask(latch));
        for(int i = 0; i < SIZE; i++)
            exec.execute(new TaskPortion(latch));
        print("Launched all tasks");
        exec.shutdown(); // Quit when all tasks complete
    }
}
