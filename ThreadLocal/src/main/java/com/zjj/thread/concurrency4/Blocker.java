package com.zjj.thread.concurrency4;

/**
 * @Author mi
 * @create 2022/2/9 0:55
 */
public class Blocker {

    synchronized void waitingCall(){
        try{
            while(!Thread.interrupted()){
                wait();
                System.out.println(Thread.currentThread()+" ");
            }
        }catch (InterruptedException e){
            // ok to exit this way
        }
    }

    synchronized void prod(){
        notify();
    }

    synchronized void prodAll(){
        notifyAll();
    }
}
