package com.github.jayuc.daily.study.day20200413;

/**
 * Created by 余杰 on 2020/5/7 10:16
 */

public class FetchImage {
    private String url;

    public FetchImage(String url) {
        this.url = url;
    }

    public void fetch(){
        System.out.println("开始下载: url ==> " + url);
        try {
            Thread.sleep(46);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("下载完成: url ==> " + url);
    }
}
