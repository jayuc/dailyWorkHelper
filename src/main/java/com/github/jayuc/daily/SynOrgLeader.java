package com.github.jayuc.daily;

import ch.qos.logback.core.db.dialect.DBUtil;
import cn.hutool.db.Entity;
import com.github.jayuc.daily.utils.DbUtil;
import lombok.ToString;

import java.util.*;

public class SynOrgLeader {
    @ToString
    static class User{
        String name;
        int id;
        int orgId;
        String position;
        String toSql(){
            return "update t_sys_org set leader_id = " + id + " where org_id = " + orgId;
        }
    }
    public static void main(String[] args) {
        String sql = "select * from t_sys_org where yes_office = 1 and leader_id is null";
        String sql1 = "select a.user_id,a.user_name,a.org_id,a.position from t_sys_user a inner join t_sys_org b on a.org_id = b.org_id " +
                "where b.leader_id = 0 and b.yes_office = 1";
        Iterator<Entity> entityIterator = DbUtil.queryListIterator(sql1);
        Map<Integer, List<User>> map = new HashMap<>();
        while (entityIterator.hasNext()){
            Entity entity = entityIterator.next();
            User user = new User();
            user.id = entity.getInt("user_id");
            user.orgId = entity.getInt("org_id");
            user.name = entity.getStr("user_name");
            user.position = entity.getStr("position");
            if(map.containsKey(user.orgId)){
                map.get(user.orgId).add(user);
            }else{
                List<User> rows = new ArrayList<>();
                rows.add(user);
                map.put(user.orgId, rows);
            }
        }

        List<String> sqls = new ArrayList<>();
        for (Map.Entry<Integer, List<User>> entry:map.entrySet()){
            List<User> userList = entry.getValue();
            boolean hasLeader = false;
            for(User user:userList){
//                if(user.position.equals("科长")){
//                    sqls.add(user.toSql());
//                    break;
//                }
//                if(user.position.indexOf("科长") > -1
//                        && user.position.indexOf("副科长") == -1
//                        ){
//                    sqls.add(user.toSql());
//                    break;
//                }
//                if(user.position.equals("主任")){
//                    sqls.add(user.toSql());
//                    hasLeader = true;
//                    break;
//                }
                if(user.position.indexOf("经理") > -1){
                    sqls.add(user.toSql());
                    hasLeader = true;
                    break;
                }
//                if(user.position.indexOf("主任") > -1
//                        && user.position.indexOf("副主任") == -1
//                        ){
//                    sqls.add(user.toSql());
//                    break;
//                }
//                if(user.position.indexOf("主持工作") > -1){
//                    sqls.add(user.toSql());
//                    break;
//                }
            }
//            if(!hasLeader){
//                for (User user:userList){
//                    if(user.position.indexOf("副主任") > -1){
//                        sqls.add(user.toSql());
//                        hasLeader = true;
//                        break;
//                    }
//                }
//            }
//            System.out.println(entry.getKey() + " ========> " + hasLeader);
        }

        sqls.forEach((s) -> {
            System.out.println(s);
        });

//        DbUtil.batchExecute(sqls);
        System.out.println();
        System.out.println("共有部门 ===> " + map.size() + "  数据  ====> " + sqls.size());
    }
}
