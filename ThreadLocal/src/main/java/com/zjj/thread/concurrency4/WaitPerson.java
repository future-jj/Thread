package com.zjj.thread.concurrency4;

import static com.zjj.thread.net.mindview.util.Print.print;

/**
 * @Author mi
 * @create 2022/2/9 1:18
 *
 * 服务员代表者消费者，要等厨师（生产者）
 */
public class WaitPerson implements Runnable {
    private Restaurant restaurant;
    public WaitPerson(Restaurant r) { restaurant = r; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    //这里一定要是while而不是if
                    while(restaurant.meal == null)
                        wait(); // ... for the chef to produce a meal
                }
                System.out.println("Waitperson got " + restaurant.meal);
                synchronized(restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // Ready for another
                }
            }
        } catch(InterruptedException e) {
            print("WaitPerson interrupted");
        }
    }
}

