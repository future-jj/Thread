package com.zjj.thread.concurrency3;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalVariableHolder {

//    ThreadLocal对象经常当作是静态域存储。当创建ThreadLocal你
//    只能通过get()和set()方法来访问该对象的内容

    // 初始化
    private static ThreadLocal<Integer> value=
            new ThreadLocal<Integer>(){
        private Random random=new Random(47);

        @Override
        protected synchronized Integer initialValue(){
            return random.nextInt(10000);
        }
    };

    public static void increment(){
        value.set(value.get()+1);
    }
    public static int get(){
        return value.get();
    }

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            executorService.execute(new Accessor(i));
        }
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        shutdown和shutdownNow的区别是，shutdown会等到线程中的任务执行完了才会退出线程
        executorService.shutdownNow();
    }
}
