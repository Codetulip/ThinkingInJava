package com.code.tulip.thinking_in_java.enumerated;

import java.text.DateFormat;
import java.util.Date;

/**
 * @EnumName ConstantSpecificMethod
 * @Description 常量相关的方法
 * @author code-tulip
 * @Date 2019/5/24 12:29 PM
 * @Version 1.0
 */
public enum ConstantSpecificMethod {

    // 表驱动代码
    DATE_TIME {
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },

    CLASSPATH {
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },

    VERSION {
        @Override
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
