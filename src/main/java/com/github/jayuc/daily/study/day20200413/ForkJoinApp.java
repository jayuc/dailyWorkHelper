package com.github.jayuc.daily.study.day20200413;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by 余杰 on 2020/5/7 11:02
 */

public class ForkJoinApp {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FetchImageTask fetchImageTask = new FetchImageTask(3);

//        singleThreadExecute(fetchImageTask);

//        forkJoinExecute(fetchImageTask);

        forkJoinAction(fetchImageTask);

        long end = System.currentTimeMillis();
        System.out.println("此次耗时: ==> " + (end - start));
    }

    static void forkJoinAction(FetchImageTask fetchImageTask){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FetchImageForkJoinAction fetchImageForkJoinTask = new FetchImageForkJoinAction(fetchImageTask.getList());
        forkJoinPool.submit(fetchImageForkJoinTask);
        try {
            forkJoinPool.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void forkJoinExecute(FetchImageTask fetchImageTask){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FetchImageForkJoinTask fetchImageForkJoinTask = new FetchImageForkJoinTask(fetchImageTask.getList());
        ForkJoinTask<Integer> result = forkJoinPool.submit(fetchImageForkJoinTask);
        int executeNum = result.invoke();
        System.out.println("共完成了 " + executeNum + " 个任务");
        forkJoinPool.shutdown();
    }

    static void singleThreadExecute(FetchImageTask fetchImageTask){
        try {
            Thread t = new Thread(fetchImageTask);
            t.start();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
