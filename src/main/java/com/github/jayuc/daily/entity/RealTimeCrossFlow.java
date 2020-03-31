package com.github.jayuc.daily.entity;

import com.github.jayuc.daily.iter.DataKeyFieldName;
import com.github.jayuc.daily.iter.RedisKeyName;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by 余杰 on 2020/3/31 14:16
 */

@Data
@RedisKeyName("RealTimeCrossFlow")
@DataKeyFieldName("crossId")
public class RealTimeCrossFlow {
    private String crossId;
    private String crossName;
    private String lonLat;
    private List<String> lstRoadId;
    private String orgPrivCode;
    private String crossShapeName;
    private String lightCtrlTypeName;
    private CrossFlowValue crossFlow1H;

    @Data
    public static class CrossFlowValue{
        private Date flowTime;
        private long total;
        private List<BranchFlowValue> lstBranchFlow;
    }

    @Data
    public static class BranchFlowValue{
        private String branchName;
        private String branchTypeName;
        private long total;
        private List<TurnFlowValue> lstTurnFlow;
    }

    @Data
    public static class TurnFlowValue{
        private String turnTypeName;
        private long total;
    }
}



