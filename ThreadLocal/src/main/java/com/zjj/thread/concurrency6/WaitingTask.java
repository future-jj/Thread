package com.zjj.thread.concurrency6;

import java.util.concurrent.CountDownLatch;

import static com.zjj.thread.net.mindview.util.Print.print;


/**
 * @Author mi
 * @create 2022/2/9 5:54
 * CountDownLatch
 */
public class WaitingTask implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;
    WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            print("Latch barrier passed for " + this);
        } catch(InterruptedException ex) {
            print(this + " interrupted");
        }
    }
    public String toString() {
        return String.format("WaitingTask %1$-3d ", id);
    }
}
