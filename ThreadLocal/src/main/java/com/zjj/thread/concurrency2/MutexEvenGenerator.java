package com.zjj.thread.concurrency2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator  extends IntGenerator{

    private int currentEvenValue=0;
    private Lock lock=new ReentrantLock();
    @Override
    public int next() {
        lock.lock();
        try{
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        }finally {
            lock.unlock();
        }

    }
}
