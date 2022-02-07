package com.zjj.thread.concurrency3;

import java.util.Random;

/*
 * @Author future-jj
 * @Description Count 来跟踪花园参观者的主机数值，并且将其作为Entrance类中的一个静态域进行存储
 * @Date 7:24 2022/2/6
 *
 **/
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

   /*
    * @Author future-jj
    * @Description
    * @Date 7:22 2022/2/6
    * @Param
    * @return count
    **/
    public synchronized int value(){
        return count;
    }
}
