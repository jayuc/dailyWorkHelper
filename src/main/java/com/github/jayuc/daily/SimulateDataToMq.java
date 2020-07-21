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

        String message = "{\"deviceType\":\"01\",\"siteCode\":\"000360050000\",\"verificationMark\":\"0\",\"orgPrivilegeCode\":\"3411\"," +
                "\"statusType\":2,\"deviceId\":\"8d6df35501ce4a6ca960e2e09a8195f1\",\"componentStatusResults\":[{\"statusType\":2," +
                "\"statusUpdateTime\":1591944989004,\"mapFaultCode\":{\"20002\":[]}}],\"lineStatisticsMark\":\"1\"," +
                "\"statusUpdateTimeStr\":\"2020-06-12 02:21:37\",\"deviceSysNbr\":\"341100000000018755\",\"ownership\":\"1\"," +
                "\"statusTime\":1591944989004,\"siteId\":\"32f0eba80da54268a70433a757d0eb11\",\"statusUpdateTime\":1591899697587}";

        String message3 = "{\"deviceType\":\"11\",\"siteCode\":\"100310001\",\"verificationMark\":\"0\",\"orgPrivilegeCode\":\"3411\",\"statusType\":1," +
                "\"deviceCurTime\":1591840244000,\"deviceId\":\"f45ef27bdce24e78aea31941d4acbc34\",\"componentStatusResults\":[{\"latestDataTime\":1591756875000," +
                "\"statusType\":2,\"deviceKey\":\"1142\",\"lastUploadTime\":1591756848651,\"statusUpdateTime\":1592025970611,\"mapFaultCode\":{\"20002\":[]}}," +
                "{\"latestDataTime\":1592023783000,\"statusType\":1,\"timeDiff\":2,\"deviceCurTime\":1591840244000,\"deviceNbr\":\"1141\",\"deviceKey\":\"1141\"," +
                "\"lastUploadTime\":1592023955342,\"statusUpdateTime\":1592025921481}],\"lineStatisticsMark\":\"1\",\"statusUpdateTimeStr\":\"2020-06-13 12:52:38\"," +
                "\"deviceSysNbr\":\"341100000000018663\",\"latestDataTime\":1592023783000,\"ownership\":\"1\",\"timeDiff\":2,\"statusTime\":1592025970611," +
                "\"mapDataRecvTime\":{\"PASS_VEH\":{\"timeDiffBySurveyData\":172,\"latestDataTime\":1592023783000,\"timeDiff\":172,\"latestRecvTime\":1592023955342," +
                "\"isErrorDataTime\":false}},\"siteId\":\"fd005052cb5749659de2f28a569b218c\",\"lastUploadTime\":1592023955342,\"statusUpdateTime\":1592023958300}";

        String message1 = "{\"collgateType\":-1,\"deviceId\":\"fdc14b45f8134a539e2866bee6cc55ae\",\"deviceKey\":\"KL0068\",\"deviceNbr\":\"KL0068\"," +
                "\"deviceSysNbr\":\"341100000000120001\",\"directionName\":\"楚雄方向\",\"directionType\":\"0\",\"districtCode\":\"341182\"," +
                "\"driveMode\":\"9\",\"facePlace\":\"800,800,900,900\",\"imageUrlPath\":\"F:0-KL0068-20200602153558784;F:1-KL0068-20200602153558784\"," +
                "\"lane\":\"1\",\"orgAuthorityCode\":\"3411\",\"orgCode\":\"341100000000\",\"passTime\":1591083358000,\"plateColor\":\"1\"," +
                "\"plateNbr\":\"皖A12345\",\"plateType\":\"01\",\"recognitionFlag\":\"0\",\"roadCode\":\"68657\",\"roadType\":\"0\"," +
                "\"siteCode\":\"000030000000\",\"snapNbr\":\"20200602153558784\",\"speed\":82," +
                "\"sysComponentId\":\"0af4875dfbd84f3088c03cb8a3732ca3\",\"transferDelay\":-46627,\"vehLocalization\":\"2\",\"vehicleColor\":\"A\"," +
                "\"vehicleLength\":9.00,\"vehiclePlatePlace\":\"779,856,941,905\",\"vehicleShape\":\"05\",\"vehicleType\":\"K31\"}";

        String message2 = "{\"collgateType\":-1,\"deviceId\":\"f45ef27bdce24e78aea31941d4acbc34\",\"deviceKey\":\"1141\",\"deviceNbr\":\"1141\"," +
                "\"deviceSysNbr\":\"341100000000018663\",\"directionName\":\"台州方向\",\"directionType\":\"3\",\"districtCode\":\"341102\",\"driveMode\":\"9\"," +
                "\"facePlace\":\"800,800,900,900\",\"imageUrl1\":\"d:\\\\MyPassingVehicleImage.rep:96219136\",\"imageUrl2\":\"d:\\\\MyPassingVehicleImage.rep:96378880\"," +
                "\"imageUrlPath\":\"http://192.168.10.153:8087/PassImage.aspx?devicenbr=1141&snapnbr=20200609093620533&server=192.168.10.153&" +
                "index=0;http://192.168.10.153:8087/PassImage.aspx?devicenbr=1141&snapnbr=20200609093620533&server=192.168.10.153&index=1\",\"lane\":\"1\"," +
                "\"orgAuthorityCode\":\"3411\",\"orgCode\":\"341100000000\",\"passTime\":1591666580000,\"plateColor\":\"1\",\"plateNbr\":\"皖A12345\"," +
                "\"plateType\":\"01\",\"recognitionFlag\":\"0\",\"roadCode\":\"47052\",\"roadType\":\"6\",\"sectionId\":\"316c108b2e3642b2afda355ace34eb8c\"," +
                "\"siteCode\":\"100310001\",\"snapNbr\":\"20200609093620533\",\"speed\":124,\"sysComponentId\":\"2e6410a82f1e4fc09f15f5bd32e620eb\"," +
                "\"transferDelay\":-31709,\"vehLocalization\":\"2\",\"vehicleColor\":\"A\",\"vehicleLength\":4.80,\"vehiclePlatePlace\":\"779,856,941,905\"," +
                "\"vehicleShape\":\"05\",\"vehicleType\":\"K31\"}";

        String pass = "its_pass_vehicle";
        String deviceStatus = "its_status_result_for_upgrade_changed";

        Boolean b = MQGateWay.publish(deviceStatus, msg);

        System.out.println("发送成功 ==>" + b);

        MQUtil.stop();

    }

}
