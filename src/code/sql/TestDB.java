package code.sql;

import java.sql.*;

/**
 * @Classname TestDB
 * @Description 手写JDBC的主要流程
 * @Author codetulip
 * @Date 2019/8/26 16:00
 * @Version 1.0
 */
public class TestDB {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1、加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        // 或者使用以下方式注册驱动
//        System.setProperty("jdbc.driver", "com.mysql.jdbc.Driver");
        /* Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
        // 指定注册的驱动（class.forName()加载驱动会加载Driver类的静态块，会使用以下方法注册驱动）
        DriverManager.registerDriver(driver); */
        // 2、使用驱动管理类，获得数据库连接(该方法会自动寻找已注册的驱动连接url)
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2",
                "root", "root");
        // 3、使用数据库连接创建声明
        Statement stmt = conn.createStatement();
//        PreparedStatement preparedStatement = conn.prepareStatement();
        // 4、使用声明执行SQL语句
        ResultSet rs = stmt.executeQuery("sql");
        // 5、遍历集合，读取数据
        boolean b = rs.next();
        rs.getString("1");
        // 6、关闭连接
        rs.close();
        conn.close();
    }

    public static void main2(String[] args) throws ClassNotFoundException {
        // 1、加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        // 或者使用以下方式注册驱动
//        System.setProperty("jdbc.driver", "com.mysql.jdbc.Driver");
        /* Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
        // 指定注册的驱动（class.forName()加载驱动会加载Driver类的静态块，会使用以下方法注册驱动）
        DriverManager.registerDriver(driver); */
        // 2、使用驱动管理类，获得数据库连接(该方法会自动寻找已注册的驱动连接url)
        Connection conn = null;
        // 3、使用数据库连接创建声明
        Statement stmt = null;
//        PreparedStatement preparedStatement = conn.prepareStatement();
        // 4、使用声明执行SQL语句
        ResultSet rs = null;
        try {
            // 创建各变量
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2",
                    "root", "root");
            stmt = conn.createStatement();
//            stmt = conn.prepareStatement("sql ");
            rs = stmt.executeQuery("sql");
            // 5、遍历集合，读取数据
            boolean b = rs.next();
            rs.getString("1");
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // 代码健壮性
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
