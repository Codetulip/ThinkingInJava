package code.enumerated;

import java.text.DateFormat;
import java.util.Date;

/**
 * @EnumName ConstantSpecificMethod
 * @Description 常量相关的方法
 * @Author tujing
 * @Date 2019/5/24 12:29 PM
 * @Version 1.0
 */
public enum ConstantSpecificMethod {

    // 表驱动代码
    DATE_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },

    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },

    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod c : values()) {
            System.out.println(c.getInfo());
        }
    }
}
