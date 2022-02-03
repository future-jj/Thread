package com.zjj.thread.concurrency;

public class DaemonSpan implements Runnable{
    @Override
    public void run() {
        while(true){
            Thread.yield();
        }
    }
}
