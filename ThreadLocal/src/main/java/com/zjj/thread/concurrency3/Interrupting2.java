package com.zjj.thread.concurrency3;

/**
 * @Author mi
 * @create 2022/2/8 1:57
 */
public class Interrupting2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Blocked2());
        t.start();
        Thread.sleep(1000);
        System.out.println("Issuing t.interrupt()");
        t.interrupt();
    }
}
