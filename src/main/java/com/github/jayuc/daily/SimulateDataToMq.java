package com.github.jayuc.daily;

import com.github.jayuc.daily.utils.MQUtil;
import cy.its.service.common.rabbitmqClient.MQGateWay;

/**
 * Created by 余杰 on 2020/6/11 16:37
 */

public class SimulateDataToMq {

    public static void main(String[] args) throws Exception {

        try {
            MQUtil.mqUtilinit("192.168.10.201");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String msg = "{\"deviceType\":\"14\",\"deviceSysNbr\":\"341100000000149911\",\"siteCode\":\"6000760016000100\"," +
                "\"orgPrivilegeCode\":\"3411\",\"ownership\":\"1\",\"statusType\":2,\"timeDiff\":0," +
                "\"statusTime\":1591865357946,\"siteId\":\"98bd2ecc8afa41298b4ba1d68ce1c6d0\"," +
                "\"deviceId\":\"01b97cf5bca04211a8a03de1a01567a2\",\"statusUpdateTime\":1591864617975,\"statusUpdateTimeStr\":\"2020-06-11 16:36:57\"}";

        Boolean b = MQGateWay.publish("its_status_result_for_upgrade", msg);

        System.out.println("发送成功 ==>" + b);

        MQUtil.stop();

    }

}
