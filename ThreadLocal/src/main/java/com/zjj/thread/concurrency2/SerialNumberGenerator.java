package com.zjj.thread.concurrency2;

public class SerialNumberGenerator {

    private static volatile int serialNumber=0;

    public static int nextSerialNumber(){
        return serialNumber++;
    }
}
