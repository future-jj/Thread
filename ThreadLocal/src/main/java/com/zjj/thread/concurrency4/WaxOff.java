package com.zjj.thread.concurrency4;

/**
 * @Author mi
 * @create 2022/2/8 23:03
 */
public class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax Off!");
                Thread.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Ending Wax Off task");
        }
    }
}
