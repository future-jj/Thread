package com.zjj.thread;

public class LiftOff implements Runnable{
    protected int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++;
    public LiftOff(){
        System.out.println("任务开始");
    }
    public LiftOff(int countDown){
        this.countDown=countDown;
    }
    public String status(){
        return "#"+id+"("+(countDown>0 ? countDown : "Liftoff!")+"),";
    }

    @Override
    public void run() {
        while(countDown-->0){
            System.out.println(status());
            Thread.yield();
        }
    }
}
