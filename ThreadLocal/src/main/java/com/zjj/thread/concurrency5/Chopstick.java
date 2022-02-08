package com.zjj.thread.concurrency5;

/**
 * @Author mi
 * @create 2022/2/9 5:29
 * 筷子类
 */
public class Chopstick {
    private boolean taken = false;

    // 筷子被拿起
    public synchronized void take() throws InterruptedException {
        while(taken)
            wait();
        taken = true;
    }

    // 筷子被放下
    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
