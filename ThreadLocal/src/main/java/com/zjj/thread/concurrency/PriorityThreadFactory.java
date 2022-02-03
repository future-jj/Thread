package com.zjj.thread.concurrency;

import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {

    private final int priority;
    PriorityThreadFactory(int priority) {
        this.priority = priority;
    }
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(priority);
        return t;
    }
}
