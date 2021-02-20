package com.github.jayuc.daily;

import cn.hutool.db.Entity;
import com.github.jayuc.daily.utils.DbUtil;
import lombok.ToString;

import java.util.*;

public class SynUserOrg {
    @ToString
    static class User{
        int userId;
        String orgCode;
    }
    public static void main(String[] args) {
        String sql = "Select * from t_sys_employ";
        Iterator<Entity> entityIterator = DbUtil.queryListIterator(sql);
        String orgSql = "select * from t_sys_org";
        Iterator<Entity> orgIterator = DbUtil.queryListIterator(orgSql);
        Map<Integer, String> orgMap = new HashMap<>();
        while (orgIterator.hasNext()){
            Entity entity = orgIterator.next();
            Integer org_id = entity.getInt("org_id");
            String org_code = entity.getStr("org_code");
            if(org_code != null){
                orgMap.put(org_id, org_code);
            }
        }
        List<User> userList = new ArrayList<>();
        while (entityIterator.hasNext()){
            Entity entity = entityIterator.next();
            Integer user_id = entity.getInt("employ_id");
            Integer org_id = entity.getInt("org_id");
            String org_code = entity.getStr("org_code");
            String s = orgMap.get(org_id);
            if(s != null && !s.equals(org_code)){
                User user = new User();
                user.orgCode = s;
                user.userId = user_id;
                userList.add(user);
            }
        }

        List<String> sqls = new ArrayList<>();
        for (User user:userList){
            sqls.add("update t_sys_employ set org_code = '" + user.orgCode +
            "' where employ_id = " + user.userId);
        }

        for (String s:sqls){
            System.out.println(s);
        }

        DbUtil.batchExecute(sqls);
    }
}
