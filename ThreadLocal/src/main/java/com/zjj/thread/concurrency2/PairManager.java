package com.zjj.thread.concurrency2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PairManager {
    AtomicInteger checkCounter=new AtomicInteger(0);

    protected Pair p=new Pair();

    private List<Pair> storage= Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair(){
        // make a copy to keep the original safe
        return new Pair(p.getX(), p.getY());
    }

    // Assume this is a time consuming operation
    protected void store(Pair p)  {
        storage.add(p);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public abstract void increment();

}
