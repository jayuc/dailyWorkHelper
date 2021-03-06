package com.github.jayuc.daily.study.day20200608;

/**
 * Created by 余杰 on 2020/6/9 14:50
 */

public class SynCountDownLatchStudy {

    public static void main(String[] args) {

        Object latch = new Object();

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
                synchronized (latch){
                    try {
                        latch.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
                synchronized (latch){
                    try {
                        latch.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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

                synchronized (latch){
                    latch.notifyAll();
                }
                System.out.println("做饭人饭做好了，开始吃饭");
            }
        });

        t1.start();
        t3.start();
        t2.start();

    }

}
