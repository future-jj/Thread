package com.zjj.thread.concurrency2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Use a critical section
public class ExplicitPairManager2 extends PairManager{

    private Lock lock= new ReentrantLock();

    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try{
            p.incrementX();
            p.incrementY();
            temp=getPair();
        }finally {
            lock.unlock();
        }
        store(temp);
    }
}
