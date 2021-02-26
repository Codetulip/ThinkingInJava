package com.code.tulip.thinking_in_java.annotations.database;

/**
 * @Classname Member
 * @Description 用以测试数据库注解
 * @author code-tulip
 * @Date 2019/5/27 10:50 AM
 * @Version 1.0
 */

@DBTable(name = "MEMBER")
public class Member {


    @SQLString(value = 30)
    String firstName;

    @SQLString(value = 50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    static int memeberCount;

    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return handle;
    }

    public Integer getAge() {
        return age;
    }
}
