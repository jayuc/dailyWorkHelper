package com.github.jayuc.daily;

import com.github.jayuc.daily.utils.DbUtil;

import java.util.ArrayList;
import java.util.List;

// 分管领导
public class SynDuty {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("update t_sys_org set deputy_id = 5 where org_id = 8");
        list.add("update t_sys_org set deputy_id = 5 where org_id = 14");
        list.add("update t_sys_org set deputy_id = 5 where org_id = 10");

        list.add("update t_sys_org set deputy_id = 3 where org_id = 2");
        list.add("update t_sys_org set deputy_id = 3 where org_id = 7");
        list.add("update t_sys_org set deputy_id = 3 where org_id = 12");

        list.add("update t_sys_org set deputy_id = 1 where org_id = 11");

        list.add("update t_sys_org set deputy_id = 6 where org_id = 3");
        list.add("update t_sys_org set deputy_id = 6 where org_id = 5");
        list.add("update t_sys_org set deputy_id = 6 where org_id = 13");

        list.add("update t_sys_org set deputy_id = 4 where org_id = 6");
        list.add("update t_sys_org set deputy_id = 4 where org_id = 9");
        list.add("update t_sys_org set deputy_id = 4 where org_id = 4");

        DbUtil.batchExecute(list);
    }
}
