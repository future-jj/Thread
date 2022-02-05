package com.zjj.thread.concurrency2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CriticalSection {

    // Test the two different approaches
    static void testApproaches(PairManager pman1,PairManager pman2){
        ExecutorService executorService= Executors.newCachedThreadPool();
        PairManipulator pm1=new PairManipulator(pman1),
                pm2=new PairManipulator(pman2);
        PairChecker pcheck1=new PairChecker(pman1);
        PairChecker pcheck2=new PairChecker(pman2);
        executorService.execute(pm1);
        executorService.execute(pm2);
        executorService.execute(pcheck1);
        executorService.execute(pcheck2);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pm1: "+pm1+" pm2: "+pm2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager pman1=new PairManager1();
        PairManager pman2=new PairManager2();
        testApproaches(pman1,pman2);
    }
}
