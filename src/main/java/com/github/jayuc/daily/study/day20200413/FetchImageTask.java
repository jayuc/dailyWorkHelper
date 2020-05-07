package com.github.jayuc.daily.study.day20200413;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by 余杰 on 2020/5/7 10:39
 */

public class FetchImageTask implements Runnable {
    private List<FetchImage> list = new ArrayList<>();
    private int size;
    private final static String IMAGE_ROOT = "http:/localhost/image/";

    public FetchImageTask(int size) {
        this.size = size;
        for (int i=1; i<this.size+1; i++){
            list.add(new FetchImage(IMAGE_ROOT + i));
        }
    }

    // 单线程执行
    @Override
    public void run() {
        list.forEach((item) -> {
            item.fetch();
        });
    }

    public List<FetchImage> getList() {
        return list;
    }
}
