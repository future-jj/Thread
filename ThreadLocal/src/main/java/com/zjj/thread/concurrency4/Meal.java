package com.zjj.thread.concurrency4;

/**
 * @Author mi
 * @create 2022/2/9 1:18
 */
public class Meal {
    private final int orderNum;
    public Meal(int orderNum) { this.orderNum = orderNum; }
    public String toString() { return "Meal " + orderNum; }
}
