package com.zjj.thread.concurrency3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author mi
 * @create 2022/2/7 1:47
 */
public class Interrupting {
    private static ExecutorService executorService=
            Executors.newCachedThreadPool();

    static void test(Runnable runnable) throws InterruptedException {
        Future<?> f=executorService.submit(runnable);
        Thread.sleep(100);
        System.out.println("Interrupting "+runnable.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupt sent to "+ runnable.getClass().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        Thread.sleep(3000);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }
}
