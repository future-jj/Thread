package com.zjj.thread.concurrency;

public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread d=new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d是否为后台线程"+d.isDaemon());
        Thread.sleep(10);
    }
}
