package com.github.jayuc.daily.utils;

import com.github.jayuc.daily.entity.RealTimeCrossFlow;
import com.github.jayuc.daily.iter.DataKeyFieldName;
import com.github.jayuc.daily.iter.RedisKeyName;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 模拟路口流量的工具类
 * Created by 余杰 on 2020/4/3 15:28
 */

public class RealTimeCrossFlowUtil {

    public static RealTimeCrossFlow.CrossFlowValue getCrossFlow(){
        RealTimeCrossFlow.CrossFlowValue crossFlowValue = new RealTimeCrossFlow.CrossFlowValue();
        crossFlowValue.setFlowTime(new Date());
        crossFlowValue.setTotal(generateRandomInteger(10000));
        crossFlowValue.setLstBranchFlow(getBranchFlowList());
        return crossFlowValue;
    }

    private static List<RealTimeCrossFlow.BranchFlowValue> getBranchFlowList(){
        List<RealTimeCrossFlow.BranchFlowValue> list = new ArrayList<>();
        list.add(getBranchFlow("东进口", generateRandomInteger(1000)));
        list.add(getBranchFlow("西进口", generateRandomInteger(1000)));
        list.add(getBranchFlow("南进口", generateRandomInteger(1000)));
        list.add(getBranchFlow("北进口", generateRandomInteger(1000)));
        return list;
    }

    private static RealTimeCrossFlow.BranchFlowValue getBranchFlow(String name, int total){
        RealTimeCrossFlow.BranchFlowValue branchFlowValue = new RealTimeCrossFlow.BranchFlowValue();
        branchFlowValue.setBranchName(name);
        branchFlowValue.setBranchTypeName(name);
        branchFlowValue.setTotal(total);
        branchFlowValue.setLstTurnFlow(getTurnFlowList());
        return branchFlowValue;
    }

    private static List<RealTimeCrossFlow.TurnFlowValue> getTurnFlowList(){
        List<RealTimeCrossFlow.TurnFlowValue> list = new ArrayList<>();
        list.add(getTurnFlow("左转", generateRandomInteger(100)));
        list.add(getTurnFlow("直行", generateRandomInteger(100)));
        list.add(getTurnFlow("右转", generateRandomInteger(100)));
        return list;
    }

    private static RealTimeCrossFlow.TurnFlowValue getTurnFlow(String name, long total){
        RealTimeCrossFlow.TurnFlowValue turnFlowValue = new RealTimeCrossFlow.TurnFlowValue();
        turnFlowValue.setTurnTypeName(name);
        turnFlowValue.setTotal(total);
        return turnFlowValue;
    }

    // bound 表示范围， 例如：100   表示在 0 到 100之间的数
    private static int generateRandomInteger(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }

}
