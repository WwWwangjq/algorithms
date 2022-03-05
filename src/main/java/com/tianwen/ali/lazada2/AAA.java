package com.tianwen.ali.lazada2;

/**
 * wangjq
 * 2021年06月03日  20:50
 */
public class AAA {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        new Thread(() -> {
            synchronized (o1) {
                System.out.println("in t1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("synchronized in 111");
                }
                System.out.println("out t1");
            }
        }).start();

        new Thread(() -> {
            synchronized (o2) {
                System.out.println("in t2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("synchronized in 222");
                }
                System.out.println("out t2");
            }
        }).start();


        try {
            Thread.sleep(10000);
            o1.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
