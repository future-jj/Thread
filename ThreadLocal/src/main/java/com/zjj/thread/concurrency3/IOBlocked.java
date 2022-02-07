package com.zjj.thread.concurrency3;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author mi
 * @create 2022/2/7 1:13
 * 不可中断阻塞
 */
public class IOBlocked implements Runnable{
    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("waiting for read()");
            in.read();
        } catch (IOException e) {
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted from blocked I/O");
            }else {
                throw new RuntimeException(e);
            }
        }
    }
}
