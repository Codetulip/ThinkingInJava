package com.code.tulip.thinking_in_java.designPatterns.adapter;

/**
 * @Classname Client
 * @Description 场景类
 * @author code-tulip
 * @Date 2019/6/19 9:48 PM
 * @Version 1.0
 */

// 适配器模式，通过将一个类的接口变成客户端所期待的另一种接口，
// 从而使原本因接口不匹配而无法再一起工作的两个类能够在一起工作了
// 也叫变压器模式，包装模式（wrapper）
public class Client {

    public static void main(String[] args) {
        // 没有适配的时候, 无法通过相同结构查到外部员工
        IUserInfo iUserInfo = new UserInfo();

        // 适配之后
        IUserInfo iUserInfo1 = new OuterUserInfo();
    }
}
