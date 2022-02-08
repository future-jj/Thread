package com.zjj.thread.concurrency4;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author mi
 * @create 2022/2/9 1:01
 */
public class NotifyVsNotifyAll {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            executorService.execute(new Task());
        }

        executorService.execute(new Task2());

        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod=true;
            @Override
            public void run() {
                if (prod){
                    System.out.println("\n notify()  ");
                    Task.blocker.prod();
                    prod=false;
                }else {
                    System.out.println("\n notifyAll()");
                    Task.blocker.prodAll();
                    prod=true;
                }
            }
        },400,400);

        Thread.sleep(5000);

        timer.cancel();

        System.out.println("\n Timer cancel");

        Thread.sleep(500);

        System.out.println("Task2.blocked.prodAll");
        Task2.blocker.prodAll();
        Thread.sleep(500);
        System.out.println("\n shutting down");
        executorService.shutdownNow();
    }

}
