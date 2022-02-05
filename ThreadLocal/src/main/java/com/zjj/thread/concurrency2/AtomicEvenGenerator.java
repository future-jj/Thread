package com.zjj.thread.concurrency2;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEvenGenerator extends IntGenerator{

    private AtomicInteger currentEvenValue=new AtomicInteger(0);

    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        /**
         * 原子类测试偶数
         */
        EvenChecker.test(new AtomicEvenGenerator());
    }

}
