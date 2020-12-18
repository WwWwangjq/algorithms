package com.tianwen.sourcecode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * wangjq
 * 2020年11月09日  21:27
 */
public class SourceCode_ReentrantLock {

    public static void main(String[] args) throws Exception {
        ReentrantLock lock =  new ReentrantLock(false);
        lock.lock();
        new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }).start();
        Thread.sleep(30000);
        lock.unlock();
    }
}
