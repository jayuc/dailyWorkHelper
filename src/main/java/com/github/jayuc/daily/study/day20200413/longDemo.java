package com.github.jayuc.daily.study.day20200413;

/**
 * Created by 余杰 on 2020/4/18 16:54
 */

public class longDemo {

    public static void main(String[] args) {

        long o = 24*60*60*1000;

        long a = 6;
        long b = 2;

        long d = 1587200227717L;
        long curr = System.currentTimeMillis();

        System.out.println(curr - d);

        System.out.println(o);


        long l = (curr - d) / (24*60*60*1000);
        int c = ((Long)l).intValue();

        System.out.println(c);
    }


}
