package com.github.jayuc.daily;

import com.github.jayuc.daily.utils.DbUtil;

import java.util.ArrayList;
import java.util.List;

public class ResetUser {
    public static void main(String[] args) {
//        List<String> sqls = new ArrayList<>();
//        sqls.add("update t_sys_user set yes_chief = 0");
//        sqls.add("update t_sys_employ set yes_chief = 0");
//        DbUtil.batchExecute(sqls);


        String str ="as,";
        List<String> list = new ArrayList<>();
        list.add(str);

        String newvalue = list.get(list.size()-1).substring(0,list.get(list.size()-1).length()-1);

        list.remove(0);
        System.out.println(newvalue);
        list.add(0, newvalue);
        System.out.println(list);
    }
}
