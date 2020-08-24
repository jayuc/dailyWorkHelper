package com.github.jayuc.daily;

import com.github.jayuc.daily.utils.MQUtil;
import cy.its.service.common.rabbitmqClient.MQGateWay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 余杰 on 2020/8/24 15:58
 */

public class SimulateVehicleMonitor {

    static final List<String> list = new ArrayList<>();

    static {

        try {
            MQUtil.mqUtilinit("192.168.10.201");
        } catch (Exception e) {
            e.printStackTrace();
        }

        list.add("{\"addressDesc\":\"苏州路与铜陵路\",\"crossCode\":\"600090002000\",\"deviceNbr\":\"341100000074\",\"deviceSysNbr\":\"341100000000002375\",\"deviceType\":\"02\",\"directionName\":\"北\",\"directionType\":\"2\",\"districtCode\":\"341101\",\"dl\":\":1:东:11;:1:东:12;:2:南:21;:2:南:22;:3:西:31;:3:西:32;:4:北:41;:4:北:42\",\"image\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510004854184&server=192.168.10.220&index=0\",\"imageUrlPath\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510004854184&server=192.168.10.220&index=0\",\"lane\":\"42\",\"orgAuthorityCode\":\"3411\",\"orgCode\":\"341100000000\",\"passCanFlag\":\"1\",\"passTime\":1597283771039,\"plateColor\":\"2\",\"plateNbr\":\"皖MT15T7\",\"plateType\":\"02\",\"pulishTime\":1597283771039,\"roadCode\":\"60009\",\"roadName\":\"苏州路\",\"roadType\":\"6\",\"sectionId\":\"\",\"siteCode\":\"000030961500\",\"snapNbr\":\"20200813095611039\",\"speed\":1,\"vehicleShape\":\"02\",\"vioCanFlag\":\"1\",\"vioTimeHour\":0,\"vioTimeMinute\":0,\"vioTimeSecond\":0}");
        list.add("{\"addressDesc\":\"上海路与永阳路\",\"crossCode\":\"600040002000\",\"deviceNbr\":\"341100000021\",\"deviceSysNbr\":\"341100000000002378\",\"deviceType\":\"02\",\"directionName\":\"南\",\"directionType\":\"2\",\"districtCode\":\"341101\",\"dl\":\":1:东:11;:1:东:12;:2:南:21;:2:南:22;:3:西:31;:3:西:32\",\"image\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510012758316&server=192.168.10.220&index=0\",\"imageUrlPath\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510012758316&server=192.168.10.220&index=0\",\"lane\":\"22\",\"orgAuthorityCode\":\"3411\",\"orgCode\":\"341100000000\",\"passCanFlag\":\"1\",\"passTime\":1597283771039,\"plateColor\":\"2\",\"plateNbr\":\"皖MP14M0\",\"plateType\":\"02\",\"pulishTime\":1597283771039,\"roadCode\":\"60004\",\"roadName\":\"上海路\",\"roadType\":\"6\",\"sectionId\":\"\",\"siteCode\":\"000030961500\",\"snapNbr\":\"20200813095611039\",\"speed\":48,\"vehicleShape\":\"02\",\"vioCanFlag\":\"1\",\"vioTimeHour\":0,\"vioTimeMinute\":0,\"vioTimeSecond\":0}");
        list.add("{\"addressDesc\":\"上海路与珠江路\",\"crossCode\":\"600040001000\",\"deviceNbr\":\"341100000116\",\"deviceSysNbr\":\"341100000000002379\",\"deviceType\":\"02\",\"directionName\":\"南\",\"directionType\":\"2\",\"districtCode\":\"341101\",\"dl\":\":1:东:11;:1:东:12;:2:南:21;:2:南:22;:3:西:31;:3:西:32\",\"image\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200511134202873&server=192.168.10.220&index=0\",\"imageUrlPath\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200511134202873&server=192.168.10.220&index=0\",\"lane\":\"22\",\"orgAuthorityCode\":\"3411\",\"orgCode\":\"341100000000\",\"passCanFlag\":\"1\",\"passTime\":1597283771039,\"plateColor\":\"2\",\"plateNbr\":\"皖M78M2K\",\"plateType\":\"02\",\"pulishTime\":1597283771039,\"roadCode\":\"60004\",\"roadName\":\"上海路\",\"roadType\":\"6\",\"sectionId\":\"\",\"siteCode\":\"000030961500\",\"snapNbr\":\"20200813095611039\",\"speed\":48,\"vehicleShape\":\"02\",\"vioCanFlag\":\"1\",\"vioTimeHour\":0,\"vioTimeMinute\":0,\"vioTimeSecond\":0}");
        list.add("{\"addressDesc\":\"皇庆湖路与洪武路电警\",\"crossCode\":\"1001\",\"deviceNbr\":\"1174\",\"deviceSysNbr\":\"341100000000018730\",\"deviceType\":\"01\",\"directionName\":\"东\",\"directionType\":\"1\",\"districtCode\":\"341100\",\"dl\":\":1:东:11;:1:东:12;:2:南:21;:2:南:22;:3:西:31;:3:西:32;:4:北:41;:4:北:42\",\"image\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510012758316&server=192.168.10.220&index=0\",\"imageUrlPath\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510004713999&server=192.168.10.220&index=0\",\"lane\":\"11\",\"orgAuthorityCode\":\"3411\",\"orgCode\":\"341100000000\",\"passCanFlag\":\"1\",\"passTime\":1597283771039,\"plateColor\":\"2\",\"plateNbr\":\"皖M151BB\",\"plateType\":\"02\",\"pulishTime\":1597283771039,\"roadCode\":\"48766\",\"roadName\":\"皇庆湖路\",\"roadType\":\"6\",\"sectionId\":\"\",\"siteCode\":\"000031341900\",\"snapNbr\":\"20200813095611039\",\"speed\":1,\"vehicleShape\":\"02\",\"vioCanFlag\":\"1\",\"vioTimeHour\":0,\"vioTimeMinute\":0,\"vioTimeSecond\":0}");
        list.add("{\"addressDesc\":\"龙蟠大道发能国际城门口\",\"crossCode\":\"10418\",\"deviceNbr\":\"1000020\",\"deviceSysNbr\":\"341100000000018785\",\"deviceType\":\"01\",\"directionName\":\"西\",\"directionType\":\"1\",\"districtCode\":\"341103\",\"dl\":\":1:东:1;:1:东:2;:1:东:3;:2:南:1;:2:南:2;:2:南:3;:3:西:1;:3:西:2;:3:西:3;:4:北:1;:4:北:2;:4:北:3\",\"image\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510004713999&server=192.168.10.220&index=0\",\"imageUrlPath\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510004713999&server=192.168.10.220&index=0\",\"lane\":\"1\",\"orgAuthorityCode\":\"3411\",\"orgCode\":\"341100000000\",\"passCanFlag\":\"1\",\"passTime\":1597283771039,\"plateColor\":\"2\",\"plateNbr\":\"皖M2U81T\",\"plateType\":\"02\",\"pulishTime\":1597283771039,\"roadCode\":\"34098\",\"roadName\":\"龙蟠大道\",\"roadType\":\"6\",\"sectionId\":\"\",\"siteCode\":\"000031341900\",\"snapNbr\":\"20200813095611039\",\"speed\":24,\"vehicleShape\":\"02\",\"vioCanFlag\":\"1\",\"vioTimeHour\":0,\"vioTimeMinute\":0,\"vioTimeSecond\":0}");

        list.add("{\"addressDesc\":\"全椒路与敬梓路\",\"crossCode\":\"10199\",\"deviceNbr\":\"106\",\"deviceSysNbr\":\"341100000000026806\",\"deviceType\":\"02\",\"directionName\":\"东\",\"directionType\":\"2\",\"districtCode\":\"341103\",\"dl\":\":1:东:1;:1:东:2;:1:东:3;:2:南:1;:2:南:2;:2:南:3;:3:西:1;:3:西:2;:3:西:3;:4:北:1;:4:北:2;:4:北:3\",\"image\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510004854184&server=192.168.10.220&index=0\",\"imageUrlPath\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510004854184&server=192.168.10.220&index=0\",\"lane\":\"3\",\"orgAuthorityCode\":\"3411\",\"orgCode\":\"341100000000\",\"passCanFlag\":\"1\",\"passTime\":1597283771039,\"plateColor\":\"2\",\"plateNbr\":\"皖M90XY5\",\"plateType\":\"02\",\"pulishTime\":1597283771039,\"roadCode\":\"82300\",\"roadName\":\"敬梓路\",\"roadType\":\"6\",\"sectionId\":\"\",\"siteCode\":\"000250100000\",\"snapNbr\":\"20200813095611039\",\"speed\":128,\"vehicleShape\":\"02\",\"vioCanFlag\":\"1\",\"vioTimeHour\":0,\"vioTimeMinute\":0,\"vioTimeSecond\":0}");
        list.add("{\"addressDesc\":\"琅琊路与紫薇路\",\"crossCode\":\"10735\",\"deviceNbr\":\"1178\",\"deviceSysNbr\":\"341100000000028208\",\"deviceType\":\"02\",\"directionName\":\"南\",\"directionType\":\"2\",\"districtCode\":\"341101\",\"dl\":\":1:东:1;:1:东:2;:1:东:3;:2:南:1;:2:南:2;:2:南:3;:3:西:1;:3:西:2;:3:西:3;:4:北:1;:4:北:2;:4:北:3\",\"image\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510012758316&server=192.168.10.220&index=0\",\"imageUrlPath\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510012758316&server=192.168.10.220&index=0\",\"lane\":\"3\",\"orgAuthorityCode\":\"3411\",\"orgCode\":\"341100000000\",\"passCanFlag\":\"1\",\"passTime\":1597283771039,\"plateColor\":\"2\",\"plateNbr\":\"皖MC78A2\",\"plateType\":\"02\",\"pulishTime\":1597283771039,\"roadCode\":\"99207\",\"roadName\":\"琅琊路\",\"roadType\":\"6\",\"sectionId\":\"\",\"siteCode\":\"000250100000\",\"snapNbr\":\"20200813095611039\",\"speed\":12,\"vehicleShape\":\"02\",\"vioCanFlag\":\"1\",\"vioTimeHour\":0,\"vioTimeMinute\":0,\"vioTimeSecond\":0}");
        list.add("{\"addressDesc\":\"扬子路与徽州路路口\",\"crossCode\":\"600160001005\",\"deviceNbr\":\"1000200\",\"deviceSysNbr\":\"341100000000029158\",\"deviceType\":\"02\",\"directionName\":\"东\",\"directionType\":\"1\",\"districtCode\":\"341100\",\"dl\":\":1:东:11;:1:东:12;:2:南:21;:2:南:22;:3:西:31;:3:西:32;:4:北:41;:4:北:42\",\"image\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200511134202873&server=192.168.10.220&index=0\",\"imageUrlPath\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200511134202873&server=192.168.10.220&index=0\",\"lane\":\"11\",\"orgAuthorityCode\":\"3411\",\"orgCode\":\"341100000000\",\"passCanFlag\":\"1\",\"passTime\":1597283771039,\"plateColor\":\"2\",\"plateNbr\":\"皖M9F6G1\",\"plateType\":\"02\",\"pulishTime\":1597283771039,\"roadCode\":\"84807\",\"roadName\":\"扬子路\",\"roadType\":\"6\",\"sectionId\":\"\",\"siteCode\":\"000250100000\",\"snapNbr\":\"20200813095611039\",\"speed\":73,\"vehicleShape\":\"02\",\"vioCanFlag\":\"1\",\"vioTimeHour\":0,\"vioTimeMinute\":0,\"vioTimeSecond\":0}");
        list.add("{\"addressDesc\":\"苏州路与芜湖路\",\"crossCode\":\"600090004000\",\"deviceNbr\":\"341100000069\",\"deviceSysNbr\":\"341100000000029160\",\"deviceType\":\"02\",\"directionName\":\"东\",\"directionType\":\"1\",\"districtCode\":\"341101\",\"dl\":\":1:东:11;:1:东:12;:2:南:21;:2:南:22;:3:西:31;:3:西:32;:4:北:41;:4:北:42\",\"image\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200511134202873&server=192.168.10.220&index=0\",\"imageUrlPath\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510004854184&server=192.168.10.220&index=0\",\"lane\":\"11\",\"orgAuthorityCode\":\"3411\",\"orgCode\":\"341100000000\",\"passCanFlag\":\"1\",\"passTime\":1597283771039,\"plateColor\":\"2\",\"plateNbr\":\"皖M2YX17\",\"plateType\":\"02\",\"pulishTime\":1597283771039,\"roadCode\":\"60009\",\"roadName\":\"苏州路\",\"roadType\":\"6\",\"sectionId\":\"\",\"siteCode\":\"000250100000\",\"snapNbr\":\"20200813095611039\",\"speed\":96,\"vehicleShape\":\"02\",\"vioCanFlag\":\"1\",\"vioTimeHour\":0,\"vioTimeMinute\":0,\"vioTimeSecond\":0}");
        list.add("{\"addressDesc\":\"琅琊路与南谯路路口\",\"crossCode\":\"600160001020\",\"deviceNbr\":\"9036\",\"deviceSysNbr\":\"341100000000029177\",\"deviceType\":\"02\",\"directionName\":\"东\",\"directionType\":\"1\",\"districtCode\":\"341101\",\"dl\":\":1:东:11;:1:东:12;:2:南:21;:2:南:22;:3:西:31;:3:西:32;:4:北:41;:4:北:42\",\"image\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510004713999&server=192.168.10.220&index=0\",\"imageUrlPath\":\"http://192.168.10.220:1800/PassImage.aspx?devicenbr=340100100417&snapnbr=20200510004713999&server=192.168.10.220&index=0\",\"lane\":\"11\",\"orgAuthorityCode\":\"3411\",\"orgCode\":\"341100000000\",\"passCanFlag\":\"1\",\"passTime\":1597283771039,\"plateColor\":\"2\",\"plateNbr\":\"皖M28S3S\",\"plateType\":\"02\",\"pulishTime\":1597283771039,\"roadCode\":\"99207\",\"roadName\":\"琅琊路\",\"roadType\":\"6\",\"sectionId\":\"\",\"siteCode\":\"000250100000\",\"snapNbr\":\"20200813095611039\",\"speed\":60,\"vehicleShape\":\"02\",\"vioCanFlag\":\"1\",\"vioTimeHour\":0,\"vioTimeMinute\":0,\"vioTimeSecond\":0}");
    }

    public static void main(String[] args) {

        System.out.println("====> 正在准备发送");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random random = new Random();

        while (true){
            int i = random.nextInt(10);
            sendMessage(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static void sendMessage(int index){

        Boolean b = MQGateWay.publish("its_pass_vehicle", list.get(index));

        System.out.println("发送成功 ==>" + b);
    }

}
