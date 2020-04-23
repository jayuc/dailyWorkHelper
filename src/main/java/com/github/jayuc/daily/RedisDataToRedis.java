package com.github.jayuc.daily;

import com.github.jayuc.daily.utils.RedisUtils;
import com.github.jayuc.daily.utils.RedisUtils2;

import java.util.Map;

/**
 * 把一个redis中的数据复制到另外一个redis中
 * Created by 余杰 on 2020/4/14 14:02
 */

public class RedisDataToRedis {

    static String flow = "TrafficSectionFlow";
    static String weatherFore = "WeatherForecast";

    static String cross = "";

    public static void main(String[] args) {

//        hashDataToAnotherRedis(weatherFore);

        RedisUtils.hmget("");

    }

    static void hashDataToAnotherRedis(String key){
        Map<Object, Object> map = RedisUtils2.hmget(key);
        if(map != null){
            map.forEach((k, v) -> {
                RedisUtils.hset(key, (String) k, v);
            });
        }
    }

}
