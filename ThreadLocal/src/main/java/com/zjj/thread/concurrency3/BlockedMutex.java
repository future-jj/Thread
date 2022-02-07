package com.zjj.thread.concurrency3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author mi
 * @create 2022/2/7 12:16
 */
public class BlockedMutex {
    private Lock lock=new ReentrantLock();

    public BlockedMutex() {
        // Acquire it right away to demonstrate interruption
        // of a task blocked on a ReentrantLock;
       lock.lock();
    }

    public void f(){
        try{
            //this will never be available to second task
            lock.lockInterruptibly();
            System.out.println("lock acquired in f()");
        } catch (InterruptedException e) {
            System.out.println("Interrupted from lock acquisition in f()");
        }
    }
}
