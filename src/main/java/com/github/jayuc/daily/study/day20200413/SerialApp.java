package com.github.jayuc.daily.study.day20200413;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by 余杰 on 2020/4/13 14:38
 */

public class SerialApp {

    static String root = "G:/log/c/";

    public static void main(String[] args) {

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(root + "ser.txt"));

            Point point = new Point();
            point.name = "世纪之点";
            point.age = 23;
            output.writeObject(point);

            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class Point implements Serializable {
        String name;
        int age;
    }

}
