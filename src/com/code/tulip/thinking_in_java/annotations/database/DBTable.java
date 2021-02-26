package com.code.tulip.thinking_in_java.annotations.database;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 */

@Target(ElementType.TYPE)   // 该注解只能应用于类
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {

    public String name() default ""; // 数据库表名
}
