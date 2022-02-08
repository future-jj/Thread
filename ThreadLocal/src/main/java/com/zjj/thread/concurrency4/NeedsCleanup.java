package com.zjj.thread.concurrency4;

/**
 * @Author mi
 * @create 2022/2/8 2:07
 */
public class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int id) {
        this.id = id;
        System.out.println("NeedsCleanup "+id);
    }

    public void cleanup(){
        System.out.println("Cleaning up "+id);
    }


}
