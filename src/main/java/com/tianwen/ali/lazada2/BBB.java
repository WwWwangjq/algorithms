package com.tianwen.ali.lazada2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * wangjq
 * 2021年06月03日  21:07
 */
public class BBB {

    private ReentrantLock lock1 = new ReentrantLock();
    private ReentrantLock lock2 = new ReentrantLock();
    private Thread t1;
    private Thread t2;

    /*public String get() {
        t1 = new Thread(() -> {
            lock1.lock();
            Thread.sleep(1000);
            lock2.lockInterruptibly();
            lock2.unlock();
            lock1.unlock();
        });

        t1.start();

        t2 = new Thread(() -> {
            lock2.lock();
            Thread.sleep(1000);
            lock1.lockInterruptibly();
            lock1.unlock();
            lock2.unlock();
        });

        t1.start();
        t2.start();
        return "";
    }

    *//** 打断阻塞线程 *//*
    public void release() {
        if (Objects.nonNull(t1)) {
            t1.interrupt();
        }
    }*/
}
