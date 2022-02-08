package com.zjj.thread.concurrency5;

import java.util.concurrent.TimeUnit;

import static com.zjj.thread.net.mindview.util.Print.print;
import static com.zjj.thread.net.mindview.util.Print.printnb;

/**
 * @Author mi
 * @create 2022/2/9 3:25
 */
public class WaxOn implements Runnable{

    private Car car;
    public WaxOn(Car c) { car = c; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                printnb("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch(InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax On task");
    }
}
