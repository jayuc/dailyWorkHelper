package com.github.jayuc.daily.study.day20200413;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 余杰 on 2020/5/6 17:22
 */

public class SysCpuCoreNumArr {

    public static void main(String[] args) {
        int cpuCoreNum = Runtime.getRuntime().availableProcessors();
        System.out.println(cpuCoreNum);

        FetchImage fetchImage = new FetchImage("http:/localhost/image/1");
        fetchImage.fetch();

        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.incrementAndGet();
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger.get());
    }
}
