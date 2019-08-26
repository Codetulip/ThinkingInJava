package code.sql.pool;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Classname MyDBPoolImpl
 * @Description 连接池实现类
 * @Author codetulip
 * @Date 2019/8/26 17:00
 * @Version 1.0
 */
public class MyDBPoolImpl implements MyDBPool {

    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;
    // 连接池默认参数
    private static int initSize = 2;
    private static int stepSize = 2;
    private static int maxSize = 10;
    private static int timeout = 1000;

    // 资源类
    private static PropertiesHolder holder = PropertiesHolder.getInstance();

    // 线程安全的连接对象容器
    private List<PoolConnection> poolList = Collections.synchronizedList(new ArrayList<PoolConnection>());

    // 初始化连接池
    static{
        initPool();
    }

    /**
     * 初始化连接池配置参数
     */
    private static void initPool() {
        // 读取连接信息
        driverClass = holder.getProperty("jdbc.driver");
        url = holder.getProperty("jdbc.url");
        username = holder.getProperty("jdbc.username");
        password = holder.getProperty("jdbc.password");
        // 读取连接池配置参数（如果没有配置，就使用默认的参数）
        initSize = holder.getProperty("jdbc.initSize") == null ? initSize : Integer.parseInt(holder.getProperty("jdbc.initSize"));
        stepSize = holder.getProperty("jdbc.stepSize") == null ? stepSize : Integer.parseInt(holder.getProperty("jdbc.stepSize"));
        maxSize = holder.getProperty("jdbc.maxSize") == null ? maxSize : Integer.parseInt(holder.getProperty("jdbc.maxSize"));
        timeout = holder.getProperty("jdbc.timeout") == null ? timeout : Integer.parseInt(holder.getProperty("jdbc.timeout"));

        // 注册驱动
        try {
            Driver driver = (Driver) Class.forName(driverClass).newInstance();
            // 指定注册的驱动
            DriverManager.registerDriver(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池中可用连接对象
     * @return 可用连接对象
     * @throws Exception
     */
    @Override
    public PoolConnection getConnection() throws Exception {
        PoolConnection poolConnection = null;
        if (poolList.size() == 0) {
            // 首次初始化连接池中连接对象
            createConnection(initSize);
        }
        // 获取连接池中空闲的连接对象(此处并不能保证取出了有效的连接对象，可能目前容器中所有的连接对象都占用了则会返回null)
        poolConnection = getRealConnection();
        // 如果容器中所有的对象都已被占用
        while (poolConnection == null) {
            // 创建更多连接对象
            createConnection(stepSize);
            poolConnection = getRealConnection();
            // 如果依然无法获取有效了解对象
            // 轮询
            if (poolConnection == null) {
                try {
                    TimeUnit.MILLISECONDS.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return poolConnection;
    }

    /**
     * 获取可用的连接对象
     * @return
     */
    private PoolConnection getRealConnection() throws SQLException {
        // 获取连接池中的所有连接对象
        for (int i = 0; i < poolList.size(); i++) {
            PoolConnection poolConnection = poolList.get(i);
            // 判断该连接对象是否可用
            if (!poolConnection.isUsed()) {
                Connection conn = poolConnection.getConnection();
                // 判断连接对象是否有效
                if (!conn.isValid(timeout)) {
                    // 如果已经失效，重新连接，并设置Connection对象
                    conn = DriverManager.getConnection(url, username, password);
                    poolConnection.setConnection(conn);
                }
                // 设置该连接对象已被占用
                poolConnection.setUsed(true);
                return poolConnection;
            }
        }
        return null;
    }

    /**
     * 创建连接池中扩增连接对象的方法
     * @param size 扩增连接池中连接对象的数量
     * @throws SQLException
     */
    private void createConnection(int size) throws SQLException {
        if (poolList.size() + size <= maxSize) {
            for (int i = 0; i < size; i++) {
                // 创建初始化连接池
                Connection connection = DriverManager.getConnection(url, username, password);
                // 包装为连接有状态的连接对象
                PoolConnection poolConnection = new PoolConnection(connection, false);
                // 加入到连接池容器中
                poolList.add(poolConnection);
            }
        }
    }
}
