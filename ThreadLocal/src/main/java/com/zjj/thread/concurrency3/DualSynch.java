package com.zjj.thread.concurrency3;

public class DualSynch {

    private Object syncObject=new Object();

    public synchronized void f(){
        for(int i=0;i<5;i++){
            System.out.println("f()");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void g(){
//        加锁的对象是syncObject不是DualSynch的实例
//        如果使用的是Lock显示锁的话，就应该使
        synchronized (syncObject){
            for (int i=0;i<5;i++){
                System.out.println("g()");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
