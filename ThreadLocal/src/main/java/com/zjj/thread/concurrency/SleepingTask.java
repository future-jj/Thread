package com.zjj.thread.concurrency;

import com.zjj.thread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SleepingTask extends LiftOff {

    @Override
    public void run() {
        while (countDown-->0){
            System.out.println(status());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
