package com.github.jayuc.daily;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import com.github.jayuc.daily.utils.DbUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 余杰 on 2020/12/15 13:53
 */

public class YCApp {
    static class Org{
        String name;
        String code;
        boolean isOrg = true;
        String toSql(int index){
            return "insert into t_sys_org (parent_id,org_name,org_code,org_code_priv,yes_office,sort) values (-1,'" +
                    name + "','" + code + "000000','" + code + "'," + (isOrg?1:0) + "," + (index+1) + ")";
        }
    }
    public static String path = "E:/code/project-documentation/合肥市烟草专卖局OA/合肥烟草员工数据(新整理)(1).xlsx";
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

        for (List<Object> row:list){
            System.out.println(row);
            String[] sa = ((String) row.get(5)).split("-");
            if(!orgMap.containsKey(sa[0])){
                orgList.add(sa[0] + rootCode + genNumber(i));
                Org o = new Org();
                o.name = sa[0];
                o.code = rootCode + genNumber(i);
                if(i>12){
                    o.isOrg = false;
                }
                oList.add(o);
                i++;
                if(i==13){
                    orgList.add("物流中心" + rootCode + genNumber(i));
                    Org oo = new Org();
                    oo.name = "物流中心";
                    oo.code = rootCode + genNumber(i);
                    oo.isOrg = false;
                    oList.add(oo);
                    i++;
                }
            }
            orgMap.put(sa[0], "1");

        }


        System.out.println();
        System.out.println();
        System.out.println("公用机构 ===> " + orgMap.entrySet().size());
        orgMap.forEach((k, v) -> {
            System.out.println(k);
        });
        System.out.println();
        System.out.println();
        orgList.forEach((v) -> {
            System.out.println(v);
        });

        List<String> lsqls = new ArrayList<>();
        for(int a=0; a<oList.size()-1; a++){
            System.out.println(oList.get(a).toSql(a));
            lsqls.add(oList.get(a).toSql(a));
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
}
