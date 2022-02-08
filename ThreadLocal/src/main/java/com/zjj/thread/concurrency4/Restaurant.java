package com.zjj.thread.concurrency4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author mi
 * @create 2022/2/9 1:19
 */
public class Restaurant {
    //考虑这样的一个饭店，他有厨师和一个服务员。
    //服务员必须等厨师准备好膳食
    //当厨师准备好了他会通知服务员
    //厨师代表生产者而服务员代表消费者
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }
    public static void main(String[] args) {
        new Restaurant();
    }
}
