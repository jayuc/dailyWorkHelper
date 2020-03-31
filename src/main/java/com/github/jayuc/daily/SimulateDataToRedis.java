package com.github.jayuc.daily;

import com.github.jayuc.daily.entity.RealTimeCrossFlow;
import com.github.jayuc.daily.iter.DataKeyFieldName;
import com.github.jayuc.daily.iter.RedisKeyName;
import com.github.jayuc.daily.utils.RedisUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 余杰 on 2020/3/31 12:05
 */

public class SimulateDataToRedis {

    public static void main(String[] args) {



        RealTimeCrossFlow.CrossFlowValue crossFlowValue = new RealTimeCrossFlow.CrossFlowValue();
        crossFlowValue.setFlowTime(new Date());
        crossFlowValue.setTotal(102);

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
        realTimeCrossFlow.setCrossFlow1H(crossFlowValue);
        realTimeCrossFlow.setLstRoadId(lstRoadId);

        toRedis(realTimeCrossFlow);
//        System.out.println(RedisUtils.hget("RealTimeCrossFlow", "2401bab9157749d9b380848184e62767"));
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

    static List<RealTimeCrossFlow.TurnFlowValue> getTurnFlowList(){
        List<RealTimeCrossFlow.TurnFlowValue> list = new ArrayList<>();
        list.add(getTurnFlow("左转", 11));
        list.add(getTurnFlow("直行", 16));
        list.add(getTurnFlow("右转", 21));
        return list;
    }

    static RealTimeCrossFlow.TurnFlowValue getTurnFlow(String name, long total){
        RealTimeCrossFlow.TurnFlowValue turnFlowValue = new RealTimeCrossFlow.TurnFlowValue();
        turnFlowValue.setTurnTypeName(name);
        turnFlowValue.setTotal(total);
        return turnFlowValue;
    }

}
