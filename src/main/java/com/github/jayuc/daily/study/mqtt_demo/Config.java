package com.github.jayuc.daily.study.mqtt_demo;

public class Config {
    /**
     * 代理服务器ip地址
     */
    public static final String MQTT_BROKER_HOST = "tcp://121.89.170.193:1883";

    /**
     * 订阅标识
     */
//    public static final String MQTT_TOPIC = "/xm/sh/response/mqtt/#";

    public static final String MQTT_TOPIC = "home/status/";

//    public static final String R_MQTT_TOPIC = "/xm/sh/request/mqtt/1320420010110561/1011/v1";

    public static final String R_MQTT_TOPIC = "test";

    public static final String userName = "admin";
    public static final String password = "public";
}
