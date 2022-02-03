package com.zjj.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec= Executors.newFixedThreadPool(1,new HandlerThreadFactory());
//        for (int i=0;i<2;i++)
        exec.execute(new ExceptionThread2());
        exec.shutdown();

    }
}
