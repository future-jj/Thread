package com.zjj.thread.concurrency2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {

    private ReentrantLock lock=new ReentrantLock();

    public void untimed(){
        //当获取到了锁之后就执行，没有获取到也会执行
        boolean captured=lock.tryLock();
        //避免造成死锁

        try{
            System.out.println("tryLock():"+captured);
        }finally {
            if (captured)
            lock.unlock();
        }
    }

    public void timed(){
        boolean captured=false;

        try{
            captured=lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            System.out.println("tryLock(2,TimeUnit.SECOND)"+captured);
        }
        finally {
            if(captured)
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final AttemptLocking al=new AttemptLocking();
        al.untimed(); //True --lock is available
        al.timed(); //True -- lock is available

        new Thread(){
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();

        Thread.sleep(300);

        al.untimed();
        al.timed();

    }

}
