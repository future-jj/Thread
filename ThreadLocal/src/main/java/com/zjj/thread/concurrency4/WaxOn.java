package com.zjj.thread.concurrency4;

/**
 * @Author mi
 * @create 2022/2/8 22:48
 */
public class WaxOn implements Runnable {

    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax on! ");
                Thread.sleep(200);// 模拟打蜡所需要的时间
                car.waxed();//
                car.waitForBuffing();//将任务挂起
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via on task");
        }
        System.out.println("Ending wax On task");
    }
}
