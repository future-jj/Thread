package com.zjj.thread.concurrency5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import static com.zjj.thread.net.mindview.util.Print.print;

/**
 * @Author mi
 * @create 2022/2/9 4:31
 */
public class TestBlockingQueues {

    /*
     * @Author future-jj
     * @Description 同步队列都只允许有一个任务插入或移除元素
     * 在java.until.concurrent.BlockingQueue接口中提供整个队列，这个接口中有大量的接口实现
     * 通常可以使用LinkedBlockingQueue 它是无界的队列
     * 还可以使用ArrayBlockingQueue，他有固定的尺寸
     * @Date 4:36 2022/2/9
     * @Param
     * @return
     **/

    static void getkey() {
        try {
            // Compensate for Windows/Linux difference in the
            // length of the result produced by the Enter key:
            new BufferedReader(
                    new InputStreamReader(System.in)).readLine();
        } catch(java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void getkey(String message) {
        print(message);
        getkey();
    }
    //将LiftOff对象执行串行化
    static void  test(String msg, BlockingQueue<LiftOff> queue) {
        print(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for(int i = 0; i < 5; i++)
            runner.add(new LiftOff(5));
        getkey("Press 'Enter' (" + msg + ")");
        t.interrupt();
        print("Finished " + msg + " test");
    }
    public static void main(String[] args) {
        test("LinkedBlockingQueue", // Unlimited size
                new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue", // Fixed size
                new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue", // Size of 1
                new SynchronousQueue<LiftOff>());
    }
}
