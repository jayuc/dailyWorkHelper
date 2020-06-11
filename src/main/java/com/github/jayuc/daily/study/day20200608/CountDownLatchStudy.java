package com.github.jayuc.daily.study.day20200608;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 余杰 on 2020/6/9 14:36
 */

public class CountDownLatchStudy {

    public static void main(String[] args) {

        int size = 3;
        CountDownLatch latch = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我开始烧水");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("烧水人烧好水，等吃饭");
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("烧水人开始吃饭");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我开始炒菜");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("炒菜人炒好菜，开始吃饭");
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("炒菜人开始吃饭");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我开始做饭");
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                System.out.println("做饭人饭做好了，开始吃饭");
            }
        });

        t1.start();
        t3.start();
        t2.start();

    }

}
