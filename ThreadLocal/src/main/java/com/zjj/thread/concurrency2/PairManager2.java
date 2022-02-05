package com.zjj.thread.concurrency2;

public class PairManager2 extends PairManager {

    @Override
    public  void increment() {
        Pair temp;
        synchronized (this){
            p.incrementY();
            p.incrementX();
            temp=getPair();
        }
        store(temp);
    }
}