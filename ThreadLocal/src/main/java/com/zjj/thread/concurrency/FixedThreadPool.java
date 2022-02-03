package com.zjj.thread.concurrency;

import com.zjj.thread.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        // 构造器代表着有限的线程数
        ExecutorService exec= Executors.newFixedThreadPool(5);
        for (int i=0;i<5;i++)
            exec.execute(new LiftOff(19));
        exec.shutdown();
    }
}
