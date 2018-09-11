package com.Concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: leaderHoo
 * @Date: 2018/9/7 14:47
 */
public class AtomicIntegerUseCase {


    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();

        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);

        t1.start();
        t2.start();

        Thread.sleep(10);

        System.out.println("count =" +MyThread.count);
        System.out.printf("a =" +MyThread.a);

    }
}

class MyThread implements  Runnable{

    static AtomicInteger a = new AtomicInteger(0);

    static  int count = 0 ;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0;i < 1000;i++){
            a.getAndIncrement();
            count++;
        }
    }
}