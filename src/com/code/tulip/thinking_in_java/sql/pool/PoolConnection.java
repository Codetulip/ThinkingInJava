package com.code.tulip.thinking_in_java.sql.pool;

import java.sql.Connection;

/**
 * @Classname PoolConnection
 * @Description 封装连接池中带有状态的连接类
 * @author codetulip
 * @Date 2019/8/26 16:55
 * @Version 1.0
 */
public class PoolConnection {

    // 数据库的连接对象
    private Connection connection;
    // 连接池中连接对象的状态 false表示空闲，true表示占用
    private boolean isUsed;


    public PoolConnection() {

    }

    public PoolConnection(Connection connection, boolean isUsed) {
        this.connection = connection;
        this.isUsed = isUsed;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    /**
     * 释放连接的方法，标识为false 表示空闲状态
     */
    public void releaseConnection() {
        this.isUsed = false;
    }
}
