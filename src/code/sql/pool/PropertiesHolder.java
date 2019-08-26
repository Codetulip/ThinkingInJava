package code.sql.pool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Classname PropertiesHolder
 * @Description 读取配置文件中的key对应的内容(资源处理类)
 * @Author codetulip
 * @Date 2019/8/26 16:40
 * @Version 1.0
 */
public class PropertiesHolder extends Properties {

    private static PropertiesHolder holder = new PropertiesHolder();

    private PropertiesHolder() {
        // 获取配置文件对象的输入流
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("code/sql/pool/datasource.properties");
        try {
            this.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static PropertiesHolder getInstance() {
        return holder;
    }

    public static void main(String[] args) {
        String property = PropertiesHolder.getInstance().getProperty("jdbc.url");
        System.out.println(property);
    }
}
