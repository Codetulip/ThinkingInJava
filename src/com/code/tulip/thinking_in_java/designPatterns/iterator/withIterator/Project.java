package com.code.tulip.thinking_in_java.designPatterns.iterator.withIterator;

import java.util.ArrayList;

/**
 * @Classname Project
 * @Description
 * @author code-tulip
 * @Date 2019/6/16 2:50 PM
 * @Version 1.0
 */
public class Project implements IProject {

    // 存放所有项目的list
    private ArrayList<IProject> list = new ArrayList<>();

    // 单个项目的信息
    private String name = "";
    private int num = 0;
    private int cost = 0;

    public Project() {

    }

    public Project(String name, int num, int cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    @Override
    public void add(String name, int num, int cost) {
        this.list.add(new Project(name, num, cost));
    }

    // 得到项目信息
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

    // 产生一个遍历对象
    @Override
    public IProjectIterator iterator() {
        return new ProjectIterator<IProject>(this.list);
    }
}
