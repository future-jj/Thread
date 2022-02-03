package com.zjj.thread.concurrency;

import com.zjj.thread.net.mindview.util.Generator;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class CallableFibonacci implements Generator<Integer>, Callable<String> {
    private int count;
    private final int n;
    public CallableFibonacci(int n) { this.n = n; }

    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    @Override
    public Integer next() {
        return fib(count++);
    }

    @Override
    public String call() throws Exception {
        Integer []sequence=new Integer[n];
        for(int i=0;i<n;i++){
            sequence[i]=next();
        }
        return "Seq. of " + n + ": " + Arrays.toString(sequence);
    }
}
