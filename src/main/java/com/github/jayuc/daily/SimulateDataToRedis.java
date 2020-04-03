package com.github.jayuc.daily;

import com.github.jayuc.daily.entity.RealTimeCrossFlow;
import com.github.jayuc.daily.iter.DataKeyFieldName;
import com.github.jayuc.daily.iter.RedisKeyName;
import com.github.jayuc.daily.utils.RealTimeCrossFlowUtil;
import com.github.jayuc.daily.utils.RedisUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by 余杰 on 2020/3/31 12:05
 */

public class SimulateDataToRedis {

    public static void main(String[] args) {

        List<String> lstRoadId = new ArrayList<>();
        lstRoadId.add("16987");
        lstRoadId.add("17047");

        RealTimeCrossFlow realTimeCrossFlow = new RealTimeCrossFlow();
        realTimeCrossFlow.setCrossId("2401bab9157749d9b380848184e62767");
        realTimeCrossFlow.setCrossName("上海路与世纪大道");
        realTimeCrossFlow.setLonLat("118.36079,32.33538");
        realTimeCrossFlow.setCrossShapeName("十字形路口");
        realTimeCrossFlow.setLightCtrlTypeName("单点控制");
        realTimeCrossFlow.setOrgPrivCode("3411");
        realTimeCrossFlow.setOrgName("滁州市交警第一大队");
        realTimeCrossFlow.setCrossFlow1H(RealTimeCrossFlowUtil.getCrossFlow());
        realTimeCrossFlow.setLstRoadId(lstRoadId);

        List<RealTimeCrossFlow.CrossFlowValue> crossFlowValueList = new ArrayList<>();
        for(int i=0; i<40; i++){
            crossFlowValueList.add(RealTimeCrossFlowUtil.getCrossFlow());
        }
        realTimeCrossFlow.setLstCrossFlow15m1d(crossFlowValueList);

        toRedis(realTimeCrossFlow);
//        System.out.println(RedisUtils.hget("RealTimeCrossFlow", "2401bab9157749d9b380848184e62767"));

//        generateRandomInteger(1000);
    }

    static void toRedis(Object object){
        Class clazz = object.getClass();
        String redisKey = object.getClass().getAnnotation(RedisKeyName.class).value();
        String keyFieldName = object.getClass().getAnnotation(DataKeyFieldName.class).value();
        String key = null;
        try {
            Method method = clazz.getMethod(getMethodByFieldName(keyFieldName));
            key = (String) method.invoke(object);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if(key != null && redisKey != null){
            RedisUtils.hset(redisKey, key, object);
        }
    }

    static String getMethodByFieldName(String fieldName){
        String firstStr = fieldName.substring(0, 1);
        String endStr = fieldName.substring(1);
        return "get" + firstStr.toUpperCase() + endStr;
    }

}
