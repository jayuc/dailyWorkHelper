package com.github.jayuc.daily;

import cn.hutool.db.Entity;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.github.jayuc.daily.utils.DbUtil;

import java.io.File;
import java.util.*;

/**
 * Created by 余杰 on 2020/12/15 13:53
 */

public class YCApp3 {
    static class Org{
        String name;
        String code;
        int parentId;
        int sort;
        int isOrg;
        String toSql(){
            return "insert into t_sys_org (parent_id,org_name,org_code,org_code_priv,yes_office,sort) values (" + parentId + ",'" +
                    name + "','" + code + "','" + code + "'," + isOrg + "," + sort + ")";
        }
    }
    public static void main(String[] args) {

        String path = "F:/code/project-documentation/合肥市烟草专卖局OA/合肥烟草员工数据(新整理)(1).xlsx";
        File file = new File(path);
        ExcelReader reader = ExcelUtil.getReader(file);
        List<List<Object>> list = reader.read(1);
        Map<Object, String> orgMap = new HashMap<>();
        List<Object> orgList = new ArrayList<>();

        List<Org> oList = new ArrayList<>();

        final String rootCode = "3400";
        int i = 0;

        Map<String, List<Object>> parentOrgMap = getOrgId();
        parentOrgMap.forEach((k, v) -> {
            System.out.println(k + " ======> " + v);
        });

        Map<String, String> xm = new HashMap<>();

        int sort = 1;
        String ps ="";
        for (List<Object> row:list){
//            System.out.println(row);
            String[] sa = ((String) row.get(5)).split("-");
            if(sa.length == 4){
//                System.out.println(row);
                String key = sa[0] + "-" + sa[1] + "-" + sa[2] + "-" + sa[3];;
                String parentName = sa[0] + "-" + sa[1] + "-" + sa[2];

                if(!orgMap.containsKey(key)){

                    orgList.add(key);
                    Org o = new Org();
                    if(xm.containsKey(parentName)){
                        if(ps.equals(parentName)){
                            sort++;
                            o.sort = sort;
                        }
                    }else {
                        sort = 1;
                        o.sort = sort;
                        ps = parentName;
                        xm.put(ps, ps);
                    }
                    o.name = key;
                    o.code = parentOrgMap.get(parentName).get(2) + genNumber(sort);
                    o.parentId = (int) parentOrgMap.get(parentName).get(0);
                    o.isOrg = (int)parentOrgMap.get(parentName).get(1);

                    oList.add(o);
                    i++;

                }
                orgMap.put(key, "1");
            }

        }


        System.out.println();
        System.out.println();
        System.out.println("公用机构 ===> " + orgMap.entrySet().size());
        orgMap.forEach((k, v) -> {
//            System.out.println(k);
        });
        System.out.println();
        System.out.println();
        orgList.forEach((v) -> {
            System.out.println(v);
        });

        List<String> lsqls = new ArrayList<>();
        for(int a=0; a<oList.size()-1; a++){
            System.out.println(oList.get(a).toSql());
            lsqls.add(oList.get(a).toSql());
        }

        DbUtil.batchExecute(lsqls);


//        final String sql = "select * from t_sys_user";
//        Iterator<Entity> entityIterator = DbUtil.queryListIterator(sql);
//        while (entityIterator.hasNext()){
//            Entity entity = entityIterator.next();
//            System.out.println(entity);
//        }
    }


    public static String genNumber(int i){
        if(i<10){
            return "0" + i;
        }
        return i + "";
    }

    public static Map<String, List<Object>> getOrgId(){
        final String sql = "select * from t_sys_org";
        Iterator<Entity> entityIterator = DbUtil.queryListIterator(sql);
        Map<String, List<Object>> map = new HashMap<>();
        while (entityIterator.hasNext()){
            Entity entity = entityIterator.next();
            System.out.println(entity);
            List<Object> l = new ArrayList<>();
            l.add(entity.getInt("org_id"));
            l.add(entity.getInt("yes_office"));
            l.add(entity.getStr("org_code_priv"));
            map.put(entity.getStr("org_name"), l);
        }
        return map;
    }
}
