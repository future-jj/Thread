package com.zjj.thread.concurrency;

public class SimpleDaemons implements Runnable{

    @Override
    public void run() {
        try{
            while(true){
                Thread.sleep(100);
                System.out.println(Thread.currentThread()+""+this);
            }
        }catch (InterruptedException e){
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<10;i++){
            Thread daemon=new Thread(new SimpleDaemons());
            daemon.setDaemon(true); //必须在线程启动之前才能把它设置为后台线程
            daemon.start();
        }
        System.out.println("ALL daemon");
        // 当程序中非后台线程执行完毕之后，程序也会杀死所有的后台线程
//        Thread.sleep(175);
    }
}
