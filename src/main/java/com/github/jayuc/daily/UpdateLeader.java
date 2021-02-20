package com.github.jayuc.daily;

import cn.hutool.core.io.FileUtil;
import cn.hutool.db.Entity;
import com.github.jayuc.daily.utils.DbUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpdateLeader {



    public static void main(String[] args) {

        final int priv = 340022;
        final int pp = 23;

        final String sql = "select * from t_sys_org where org_code like '" + priv + "%'";

        Iterator<Entity> entityIterator = DbUtil.queryListIterator(sql);

        int maxSort = 1;
        List<Integer> list = new ArrayList<>();
        while (entityIterator.hasNext()){
            Entity entity = entityIterator.next();
            String orgName = entity.getStr("org_name");
            Integer org_id = entity.getInt("org_id");
            Integer sort = entity.getInt("sort");
            String org_code_priv = entity.getStr("org_code_priv");
            if(org_code_priv.length() == 8){
                if(sort >maxSort){
                    maxSort = sort;
                }
            }
            if(org_code_priv.length() == 10){
                list.add(org_id);
            }
        }

        System.out.println("max ===> " + maxSort);
        System.out.println(list);

        List<String> sqls = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            String p = priv + "0" + (++maxSort);
            sqls.add("update t_sys_org set org_code = '" + p + "0000', org_code_priv = '" + p + "'" +
                    ", sort = " + maxSort + ", parent_id = " + pp +
               " where org_id = " + list.get(i));
        }

        sqls.forEach((s) -> {
            System.out.println(s);
        });

        DbUtil.batchExecute(sqls);

    }

}
