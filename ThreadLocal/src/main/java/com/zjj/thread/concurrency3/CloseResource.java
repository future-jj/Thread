package com.zjj.thread.concurrency3;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author mi
 * @create 2022/2/7 11:18
 * I/O会锁住你多线程程序的潜在的可能
 */
public class CloseResource {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        ServerSocket serverSocket=new ServerSocket(8080);
        InputStream socketInput=new Socket("localhost",8080).getInputStream();
        executorService.execute(new IOBlocked(socketInput));
        executorService.execute(new IOBlocked(System.in));
        Thread.sleep(100);
        System.out.println("Shutting down all threads");
        executorService.shutdownNow();
        Thread.sleep(1000);
        System.out.println("Closing "+socketInput.getClass().getName());
        socketInput.close();
        Thread.sleep(1000);
        System.out.println("Closing "+System.in.getClass().getName());
        System.in.close();
    }
}
