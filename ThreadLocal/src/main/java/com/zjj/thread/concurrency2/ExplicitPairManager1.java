package com.zjj.thread.concurrency2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// synchronize the entire method
public class ExplicitPairManager1 extends PairManager{

    private Lock lock=new ReentrantLock();

    @Override
    public synchronized void increment() {
        lock.lock();
        try{
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }

}
