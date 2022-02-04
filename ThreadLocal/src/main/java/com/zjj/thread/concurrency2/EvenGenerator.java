package com.zjj.thread.concurrency2;

public class EvenGenerator extends IntGenerator{

    private int currentEventValue=0;

    @Override
    public synchronized int next() {
        ++currentEventValue;
        //不是原子操作，危险
        //要控制对共享资源的访问就需要先把它包装成一个对象，然后将所有访问资源的方法都包装成synchronized
        ++currentEventValue;
        return currentEventValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
