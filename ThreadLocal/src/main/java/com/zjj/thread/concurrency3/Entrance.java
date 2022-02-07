package com.zjj.thread.concurrency3;

import java.util.ArrayList;
import java.util.List;

public class Entrance implements Runnable{

    private static Count count=new Count();
    //并且将Count作为Entrance类中的一个静态域进行存储
    private static List<Entrance>  entrances=new ArrayList<>();

    private int number=0;
    // Doesn't need synchronization to read
    private final int id;
    private static volatile boolean canceled=false;
    public static void cancel(){
        canceled=true;
    }

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    @Override
    public void run() {
     while (!canceled){
         synchronized (this){
             ++number;
         }
         System.out.println(this+"Total: "+count.increment());
         try {
             Thread.sleep(100);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
        System.out.println("Stopping "+this);
    }

    public synchronized int getValue(){
        return number;
    }

    @Override
    public String toString() {
        return "Entrance{" +
                "number=" + getValue() +
                ", id=" + id +
                '}';
    }

    public static int getTotalCount(){
        return count.value();
    }

    public static int sumEntrances(){
        int sum=0;
        for(Entrance entrance:entrances){
            sum+=entrance.getValue();
        }
        return sum;
    }
}
