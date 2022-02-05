package com.zjj.thread.concurrency2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 检验是否为偶数
 */
public class EvenChecker implements Runnable{

    public IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator g,int ident){
        generator=g;
        id=ident;
    }

    @Override
    public void run() {
        while(!generator.isCanceled()){
            int val=generator.next();
            if(val%2!=0){
                System.out.println(val+" 不是偶数");
                generator.cancel();
            }else{
                System.out.println(val+" 偶数");
            }
        }
    }

    public static void test(IntGenerator gp,int count){
        System.out.println("press Control-C to exit");
        ExecutorService exec= Executors.newCachedThreadPool();
        for(int i=0;i<count;i++){
            exec.execute(new EvenChecker(gp,i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp){
        test(gp,10);
    }
}
