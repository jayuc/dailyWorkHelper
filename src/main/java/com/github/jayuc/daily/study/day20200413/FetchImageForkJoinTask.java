package com.github.jayuc.daily.study.day20200413;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by 余杰 on 2020/5/7 14:10
 */

public class FetchImageForkJoinTask extends RecursiveTask<Integer> {
    private List<FetchImage> list = new ArrayList<>();

    public FetchImageForkJoinTask(List<FetchImage> list) {
//        System.out.println("FetchImageForkJoinTask construct ...");
        this.list = list;
    }

    @Override
    protected Integer compute() {
//        System.out.println(Thread.currentThread().getName() + " ----------- " + list.size());
        int size = list.size();
        if(size == 1){
            list.get(0).fetch();
            return 1;
        }else if (size > 1){
            int middle = size/2;
            List<FetchImage> preList = list.subList(0, middle);
            List<FetchImage> lastList = list.subList(middle, size);
            FetchImageForkJoinTask preTask = new FetchImageForkJoinTask(preList);
            FetchImageForkJoinTask lastTask = new FetchImageForkJoinTask(lastList);
            preTask.fork();
            lastTask.fork();
            return preTask.join() + lastTask.join();
        }
        return 0;
    }
}
