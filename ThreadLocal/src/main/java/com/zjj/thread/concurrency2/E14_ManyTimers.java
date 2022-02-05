package com.zjj.thread.concurrency2;

import java.util.Timer;
import java.util.TimerTask;

public class E14_ManyTimers {
    public static void main(String[] args) throws InterruptedException {

        if (args.length<1){
            System.err.println("Usage: java E14_ManyTimers <num of timers>");
        }
        int numOfTimers=Integer.parseInt(args[0]);
        for (int i=0;i<numOfTimers;i++){
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    //打印当前的系统时间
                    System.out.println(System.currentTimeMillis());
                }
            },numOfTimers-1);
        }

        Thread.sleep(2*numOfTimers);
        System.out.println("休眠结束");
    }
}
