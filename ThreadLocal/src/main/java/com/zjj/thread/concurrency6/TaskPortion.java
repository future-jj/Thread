package com.zjj.thread.concurrency6;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static com.zjj.thread.net.mindview.util.Print.print;

/**
 * @Author mi
 * @Create 2022/2/9 5:51
 */
public class TaskPortion implements Runnable{

    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private final CountDownLatch latch;
    TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            doWork();
            //递减锁存器的计数，如果计数到达零，则释放所有等待的线程。如果当前计数大于零，则将计数减少.
            latch.countDown();
        } catch(InterruptedException ex) {
            // Acceptable way to exit
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        print(this + "completed");
    }
    public String toString() {
        return String.format("%1$-3d ", id);
    }
}
