package com.code.tulip.thinking_in_java.sql.pool;

/**
 * @Classname MyDBPool
 * @Description 连接池接口
 * @author codetulip
 * @Date 2019/8/26 16:55
 * @Version 1.0
 */
public interface MyDBPool {

    /**
     * 定义获取连接池中连接对象的方法
     * @return
     */
    PoolConnection getConnection() throws Exception;
}
