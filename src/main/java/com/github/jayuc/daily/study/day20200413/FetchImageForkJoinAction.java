package com.github.jayuc.daily.study.day20200413;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by 余杰 on 2020/5/7 16:50
 */

public class FetchImageForkJoinAction extends RecursiveAction {
    private List<FetchImage> list;

    public FetchImageForkJoinAction(List<FetchImage> list) {
        this.list = list;
    }

    @Override
    protected void compute() {
        int size = list.size();
        if(size == 1){
            System.out.println("---------------------> 执行了 ==> " + list.size());
            list.get(0).fetch();
        }else if (size > 1){
            int middle = size/2;
            List<FetchImage> preList = list.subList(0, middle);
            List<FetchImage> lastList = list.subList(middle, size);
            FetchImageForkJoinTask preTask = new FetchImageForkJoinTask(preList);
            FetchImageForkJoinTask lastTask = new FetchImageForkJoinTask(lastList);
            preTask.fork();
            lastTask.fork();
        }
    }
}
