package com.github.jayuc.daily.study.mqtt_demo;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttServer {

    /**
     * 客户端唯一标识
     */
    public static final String MQTT_CLIENT_ID = "android_server_xiasuhuei32";
    private static MqttTopic topic;
    private static MqttClient client;

    public static void main(String... args) {
        // 推送消息
        MqttMessage message = new MqttMessage();
        try {
            client = new MqttClient(Config.MQTT_BROKER_HOST, MQTT_CLIENT_ID, new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setUserName(Config.userName);
            options.setPassword(Config.password.toCharArray());
            options.setConnectionTimeout(10);
            options.setKeepAliveInterval(20);

            topic = client.getTopic(Config.R_MQTT_TOPIC);

            message.setQos(0);
            message.setRetained(false);
            long n = System.currentTimeMillis();
            String m = "{\"header\":{\"timeStamp\":\"" + n + "\"},\"payload\":{\"devices\":[{\"nodeid\":\"000\",\"action\":\"command\",\"params\":\"0110111100000000\"}]}}";
            m = "11111111";
            message.setPayload(m.getBytes());
            client.connect(options);

//            while (true) {
                MqttDeliveryToken token = topic.publish(message);
                token.waitForCompletion();
                System.out.println("已经发送 -------------------------------------------- ");
                Thread.sleep(10000);
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
