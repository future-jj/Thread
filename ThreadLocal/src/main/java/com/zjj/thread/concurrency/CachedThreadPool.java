package com.zjj.thread.concurrency;

import com.zjj.thread.LiftOff;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            exec.execute(new LiftOff(3));
        }
        exec.shutdown();
    }
}
