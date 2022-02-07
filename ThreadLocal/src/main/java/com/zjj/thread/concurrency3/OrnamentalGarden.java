package com.zjj.thread.concurrency3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrnamentalGarden {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            executorService.execute(new Entrance(i));
        //Run for a while ,then stop and collect the data
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Entrance.cancel();
        executorService.shutdown();
        try {
            //awaitTermination等待每一个任务结束，如果所有的任务在超过时间达到之前全部结束，则返回true，否则返回false
            if (!executorService.awaitTermination(250, TimeUnit.MILLISECONDS)) {
                System.out.println("Some tasks were not terminated!");
            }
            System.out.println("Total: " + Entrance.getTotalCount());
            System.out.println("Sum of Entrances: " + Entrance.sumEntrances());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
