package com.zjj.thread.concurrency2;

public class PairManager1 extends PairManager {

    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }

}
