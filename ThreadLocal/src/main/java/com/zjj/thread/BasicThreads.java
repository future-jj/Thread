package com.zjj.thread;

public class BasicThreads {
    public static void main(String[] args) {
        for(int i=0;i<2;i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting for Liftoff");
    }
}
