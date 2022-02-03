package com.zjj.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonFromFactory implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread()+" "+this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i=0;i<10;i++){
            executorService.execute(new DaemonFromFactory());
        }
        System.out.println("All Daemon started");
//        Thread.sleep(500);
    }
}
