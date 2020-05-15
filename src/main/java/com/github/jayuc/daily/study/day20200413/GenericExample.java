package com.github.jayuc.daily.study.day20200413;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 余杰 on 2020/5/15 11:15
 */

public class GenericExample implements GenericDemo {
    @Override
    public <E> List<E> list(String name) {

        byte a = 23;

        List<String> list = new ArrayList<String>();
        List<E> result = (List<E>) list;

        List<Object> a1 = new ArrayList<>();
        return (List<E>) a1;

    }

    @Override
    public <T> T note(String name) {
        return (T) new Object();
    }
}
