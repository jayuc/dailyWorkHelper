package com.github.jayuc.daily;

import cn.hutool.db.Entity;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.github.jayuc.daily.utils.DbUtil;
import lombok.ToString;

import java.io.File;
import java.util.*;

public class handleUser {
    @ToString
    static class User{
        String code;
        int orgId;
        String name;
        String loginName;
        String position;
        int sex;
        String toSql(){
            return "insert into t_sys_user (user_code,org_id,user_name,login_name,password,position,sex) values ('" +
                    code + "'," + orgId + ",'" + name + "','" + loginName + "','e10adc3949ba59abbe56e057f20f883e','" +
                    position + "'," + sex + ")";
        }
    }
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(new File(YCApp.path));
        List<List<Object>> list = reader.read(1);
        Map<String, Integer> orgMap = new HashMap<>();
        List<User> userList = new ArrayList<>();

        String sql = "select * from t_sys_org";
        Iterator<Entity> entityIterator = DbUtil.queryListIterator(sql);
        while (entityIterator.hasNext()){
            Entity entity = entityIterator.next();
            String name = entity.getStr("org_name");
            int id = entity.getInt("org_id");
            orgMap.put(name, id);
        }

        orgMap.forEach((k, v) -> {
//            System.out.println(k + " ===> " + v);
        });

        List<String> sqls = new ArrayList<>();
        System.out.println("共记录数 ===> " + list.size());
        list.forEach((item) -> {
            System.out.println(item);
            User user = new User();
            user.code = (String) item.get(0);
            user.name = (String) item.get(1);
            user.sex = ((String) item.get(2)).equals("男") ? 1 : 2;
            user.loginName = (String) item.get(3);
            user.position = (String) item.get(4);
            user.orgId = orgMap.get(item.get(5));
            userList.add(user);
            sqls.add(user.toSql());
        });
        System.out.println();
        userList.forEach((user -> {
            System.out.println(user);
        }));

        System.out.println();
        System.out.println("共记录数 ===> " + list.size());

        sqls.forEach((s) -> {
            System.out.println(s);
        });

        System.out.println(" ===> " + sqls.size());

        DbUtil.batchExecute(sqls);

    }
}
