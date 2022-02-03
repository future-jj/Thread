package com.zjj.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E09_SimplePrioritiesTF {
    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MAX_PRIORITY));

        for (int i=0;i<5;i++){
            exec.execute(new SimplePriorities2());
        }

        Thread.yield();

    }
}
