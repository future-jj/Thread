package com.zjj.thread.concurrency3;

/**
 * @Author mi
 * @create 2022/2/8 1:54
 */
public class Blocked2 implements Runnable {
    BlockedMutex blockedMutex=new BlockedMutex();

    @Override
    public void run() {
        System.out.println("Waiting for f() in BlockedMutex");
        blockedMutex.f();
        System.out.println("Broken out of blocked call");
    }
}
