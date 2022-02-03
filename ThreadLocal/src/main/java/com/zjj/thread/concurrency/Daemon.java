package com.zjj.thread.concurrency;

public class Daemon implements Runnable{

    private Thread [] t=new Thread[10];

    @Override
    public void run() {
        for (int i=0;i<t.length;i++){
            t[i]=new Thread(new DaemonSpan());
            t[i].start();
            System.out.println("DaemonSpan"+i+"started,");
        }
        for(int i=0;i<t.length;i++){
            System.out.println("t["+i+"]"+t[i].isDaemon());
        }
        while(true){
            Thread.yield();
        }
    }
}
