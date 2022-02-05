package com.zjj.thread.concurrency2;

public class PairManager2 extends PairManager {

    @Override
    public  void increment() {

        //不对整个方法加synchronized而是对部分加临界区，这样对象不加锁的时间就会更长，这也是宁愿使用同步控制块
        //而不是对整个方法进行同步控制的典型原因
        Pair temp;
        synchronized (this){
            p.incrementY();
            p.incrementX();
            temp=getPair();
        }
        store(temp);
    }
}