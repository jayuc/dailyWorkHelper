package com.github.jayuc.daily;

import cn.hutool.db.Entity;
import com.github.jayuc.daily.utils.DbUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class YesOffice {
    public static void main(String[] args) {
        get();
    }
    public static Map<Integer, String> get(){
        String sql = "select a.org_id,b.org_name,a.t from\n" +
                "(select org_id,count(org_id) t from t_sys_user where yes_chief = 1 group by org_id) a left join \n" +
                "t_sys_org b on a.org_id = b.org_id";
        Iterator<Entity> entityIterator = DbUtil.queryListIterator(sql);
        Map<Integer, String> map = new HashMap<>();
        while (entityIterator.hasNext()){
            Entity entity = entityIterator.next();
            Integer orgId = entity.getInt("org_id");
            map.put(orgId, "1");
            System.out.println(orgId);
        }
        return map;
    }
}
