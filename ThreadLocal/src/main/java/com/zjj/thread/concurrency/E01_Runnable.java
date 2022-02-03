package com.zjj.thread.concurrency;

public class E01_Runnable {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++)
            new Thread(new Printer()).start();
    }
}
