package com.code.tulip.thinking_in_java.designPatterns.composite;

/**
 * @Classname Leaf
 * @Description 树叶
 * @author code-tulip
 * @Date 2019/6/16 8:53 PM
 * @Version 1.0
 */
public class Leaf implements ILeaf{

    // 姓名
    private String name = "";

    // 职位
    private String position = "";

    // 薪水
    private int salary = 0;

    public Leaf(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // 获取信息
    @Override
    public String getInfo() {
        String info = "";
        info = "姓名：" + this.name;
        info = info + "\t职位: " + this.position;
        info = info + "\t薪水: " + this.salary;
        return info;
    }
}
