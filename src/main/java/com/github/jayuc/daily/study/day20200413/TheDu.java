package com.github.jayuc.daily.study.day20200413;

/**
 * Created by 余杰 on 2020/5/11 17:42
 */

public class TheDu<T> {
    T value;
    T getValue(){
        return value;
    }

    T a(T e){
        return e;
    }

    public static void main(String[] args) {
        TheDu<String> a = new TheDu<>();
        System.out.println(a.getValue());
        System.out.println(a.a("e"));
    }
}
