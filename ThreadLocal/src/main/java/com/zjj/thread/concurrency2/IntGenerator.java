package com.zjj.thread.concurrency2;

public abstract class IntGenerator {
    private  boolean canceled=false;
    public abstract int next();
    public void cancel(){
        canceled=true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
