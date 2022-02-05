package com.zjj.thread.concurrency3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrnamentalGarden {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            executorService.execute(new Entrance(i));
            //Run for a while ,then stop and collect the data
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Entrance.cancel();
            executorService.shutdown();
            try {
                if(!executorService.awaitTermination(250, TimeUnit.MILLISECONDS)){
                    System.out.println("Some tasks were not terminated!");
                }
                System.out.println("Total: "+Entrance.getTotalCount());
                System.out.println("Sum of Entrances: "+Entrance.sumEntrances());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
