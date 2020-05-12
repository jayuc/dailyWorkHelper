package com.github.jayuc.daily.study.day20200413;

import java.util.List;

/**
 * Created by 余杰 on 2020/5/11 17:25
 */

public class MyHash<K, V> {
    private List<V> list;
    public V getValue(){
        return list.get(0);
    }
}
