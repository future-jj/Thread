package com.zjj.thread.concurrency5;

import java.util.concurrent.TimeUnit;

import static com.zjj.thread.net.mindview.util.Print.print;
import static com.zjj.thread.net.mindview.util.Print.printnb;

/**
 * @Author mi
 * @create 2022/2/9 3:26
 */
public class WaxOff implements Runnable{

    private Car car;
    public WaxOff(Car c) { car = c; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                car.waitForWaxing();
                printnb("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch(InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax Off task");
    }
}
