package com.zjj.thread.concurrency4;

/**
 * @Author mi
 * @create 2022/2/8 22:47
 */
public class Car {
    private boolean waxOn=false;// 表示涂蜡抛光处理的状态

    /*
     * @Author future-jj
     * @Description 是时候应该干点什么了，那么就必须获得整个对象的锁
     * @Date 23:43 2022/2/8
     * @Param
     * @return
     **/
    public synchronized void waxed(){

        waxOn=true;  //read to buff
        notifyAll();
    }

    public synchronized void buffed(){
        waxOn=false; // Ready for another coat of wax
        notifyAll();
    }

    /*
     * @Author future-jj
     * @Description 检查waxOn的标志，
     * @Date 23:38 2022/2/8
     * @Param
     * @return
     **/
    public synchronized void waitForWaxing() throws InterruptedException {

        while (waxOn==false){
//            如果为waxOn为false，将会被挂起
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn==true){
            wait();
        }
    }

}
