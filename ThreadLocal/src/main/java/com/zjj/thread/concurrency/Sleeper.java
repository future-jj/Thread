package com.zjj.thread.concurrency;

public class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name,int sleepTime){
        super(name);
        duration=sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName()+"被打断 "+isInterrupted());
        }
        System.out.println(getName()+" 被唤醒");
    }
}
