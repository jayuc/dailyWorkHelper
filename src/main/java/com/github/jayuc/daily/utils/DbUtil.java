package com.github.jayuc.daily.utils;

import cn.hutool.db.Entity;
import cn.hutool.db.handler.EntityListHandler;
import cn.hutool.db.sql.SqlExecutor;
import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DbUtil {

    static DruidDataSource druidDataSource1;

    static {
        druidDataSource1 = new DruidDataSource();
        druidDataSource1.setUrl("jdbc:mysql://121.89.170.193:3306/oa?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC");
        druidDataSource1.setUsername("root");
        druidDataSource1.setPassword("123456");
        druidDataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }

    public static Iterator<Entity> queryListIterator(String sql, Object... params){
        Connection connection = null;
        try {
            connection = druidDataSource1.getConnection();
            List<Entity> entityList = SqlExecutor.query(connection, sql, new EntityListHandler(), params);
            Iterator<Entity> iterator = entityList.iterator();
            return iterator;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int execute(String sql){
        Connection connection = null;
        try {
            connection = druidDataSource1.getConnection();
            return SqlExecutor.execute(connection, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int[] batchExecute(List<String> sqls){
        Connection connection = null;
        try {
            connection = druidDataSource1.getConnection();
            return SqlExecutor.executeBatch(connection, sqls);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
