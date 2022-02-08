package com.zjj.thread.concurrency4;

/**
 * @Author mi
 * @create 2022/2/9 0:43
 */
public class Coop1 implements Runnable{

    public Coop1() {
        System.out.println("Construct Coop1");
    }

    @Override
    public void run() {
        System.out.println("Coop1 going to wait");

    }
}
