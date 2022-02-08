package com.zjj.thread.concurrency5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author mi
 * @create 2022/2/9 5:09
 */
public class ToastOMatic {
    // 一个制作土司
    // 一个给土司抹油
    // 另一个在抹过黄油的土司上涂果酱
    public static void main(String[] args) throws Exception {
        ToastQueue dryQueue = new ToastQueue(), //制作土司
                butteredQueue = new ToastQueue(), // 给吐司抹油
                finishedQueue = new ToastQueue(); //涂果酱
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
