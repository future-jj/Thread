package com.zjj.thread.concurrency5;

import java.io.IOException;
import java.io.PipedReader;

import static com.zjj.thread.net.mindview.util.Print.print;
import static com.zjj.thread.net.mindview.util.Print.printnb;

/**
 * @Author mi
 * @create 2022/2/9 5:17
 */
public class Receiver implements Runnable{
    private PipedReader in;
    public Receiver(Sender sender) throws IOException {
        // PipeReader的建立必须在构造器中和一个pipeWriter相关联
        in = new PipedReader(sender.getPipedWriter());
    }
    public void run() {
        try {
            while(true) {
                // Blocks until characters are there:
                printnb("Read: " + (char)in.read() + ", ");
                //PipeReader和普通的I/O之间的区别是PipeReader是可以中断的
            }
        } catch(IOException e) {
            print(e + " Receiver read exception");
        }
    }
}
