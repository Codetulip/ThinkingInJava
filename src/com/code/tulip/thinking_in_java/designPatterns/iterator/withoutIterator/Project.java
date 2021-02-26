package com.code.tulip.thinking_in_java.designPatterns.iterator.withoutIterator;

/**
 * @Classname Project
 * @Description 项目信息的实现
 * @author code-tulip
 * @Date 2019/6/16 2:22 PM
 * @Version 1.0
 */
public class Project implements IProject {

    // 项目名称
    private String name = "";

    // 项目成员数量
    private int num = 0;

    // 项目费用
    private int cost = 0;

    // 定义构造函数，把想看到的信息都存储起来
    public Project(String name, int num, int cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    @Override
    public String getProjectInfo() {
        String info = "";
        // 获得项目的名称
        info = info + "项目名称是： " + this.name;
        // 获得项目的人数
        info = info + "\t项目人数是： " + this.num;
        // 获得项目费用
        info = info + "\t项目费用： " + this.cost;
        return info;
    }
}
