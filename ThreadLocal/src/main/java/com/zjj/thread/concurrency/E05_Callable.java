package com.zjj.thread.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class E05_Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec= Executors.newCachedThreadPool();
        List<Future<String>> results=new ArrayList<>();
        for(int i=0;i<10;i++){
            results.add(exec.submit(new CallableFibonacci(i)));
        }
        for (Future<String> fs:results) {
            System.out.println(fs.get());
        }
    }
}
