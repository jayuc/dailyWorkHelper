package com.github.jayuc.daily;

import cn.hutool.db.Entity;
import com.github.jayuc.daily.utils.DbUtil;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SynOffice {
    @ToString
    static class User{
        int id;
        String code;
        String name;
        String position;
        int orgId;
        int yesOffice;
        String toEmploySql(){
            return "update t_sys_employ set yes_chief = 1 where employ_code = '" + code + "'";
        }
        String toUserSql(){
            return "update t_sys_user set yes_chief = 1 where user_code = '" + code + "'";
        }
    }
    public static void main(String[] args) {
        String sql = "select * from t_sys_employ where yes_chief = 0";
        Iterator<Entity> entityIterator = DbUtil.queryListIterator(sql);
        List<User> userList = new ArrayList<>();
        Map<Integer, String> cm = YesOffice.get();
        while (entityIterator.hasNext()){
            Entity entity = entityIterator.next();
            String position = entity.getStr("position");
            System.out.println(entity.getStr("employ_name") + " ====> " + position);
            Integer org_id = entity.getInt("org_id");
            if(position.indexOf("主任") > -1 && !cm.containsKey(org_id)){
                User user = new User();
                user.position = position;
                user.id = entity.getInt("employ_id");
                user.orgId = entity.getInt("org_id");
                user.yesOffice = 1;
                user.name = entity.getStr("employ_name");
                user.code = entity.getStr("employ_code");
                userList.add(user);
            }
        }
        List<String> sqls = new ArrayList<>();
        userList.forEach((user -> {
            System.out.println(user);
            System.out.println(user.toEmploySql());
            System.out.println(user.toUserSql());
            sqls.add(user.toEmploySql());
            sqls.add(user.toUserSql());
        }));
        System.out.println(" ===> " + userList.size());

        DbUtil.batchExecute(sqls);
    }
}
