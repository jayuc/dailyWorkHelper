package com.github.jayuc.daily.study.day20200608;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 余杰 on 2020/6/8 8:54
 */

public class AQSstudy {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();


        CountDownLatch latch = new CountDownLatch(1);
        latch.countDown();

        CyclicBarrier barrier = new CyclicBarrier(1);

    }

}
