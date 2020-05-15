package com.github.jayuc.daily.study.day20200413;

import java.util.List;

/**
 * Created by 余杰 on 2020/5/15 11:14
 */

public interface GenericDemo {
    <T> T note(String name);
    <E> List<E> list(String name);
}
