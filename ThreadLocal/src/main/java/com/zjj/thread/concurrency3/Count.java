package com.zjj.thread.concurrency3;

import java.util.Random;

/**
 * 花园委员会希望了解每天通过多个大门进入花园的总人数。
 */
public class Count {
    private int count=0;
    private Random rand=new Random(47);

    // Remove the synchronized keyword to see counting fail
    public synchronized int increment(){
        int temp=count;
        if(rand.nextBoolean()){  //yield half the time
            Thread.yield();
        }
        return (count=++temp);
    }

    public synchronized int value(){
        return count;
    }
}
