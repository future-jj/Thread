package com.zjj.thread.concurrency;

import java.io.IOException;

public class UnresponsiveUI {
    private volatile double d=1;
    public UnresponsiveUI() throws IOException {
        while(d>0){
            d=d+(Math.PI+Math.E)/d;

        }
        System.in.read(); //几乎不会到这一步
    }
}
