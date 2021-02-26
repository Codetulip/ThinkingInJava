package com.code.tulip.thinking_in_java.designPatterns.composite;

import java.util.ArrayList;

/**
 * @Classname Branch
 * @Description 树枝节点实现类
 * @author code-tulip
 * @Date 2019/6/16 8:57 PM
 * @Version 1.0
 */
public class Branch implements IBranch {

    // 姓名
    private String name = "";

    // 职位
    private String position = "";

    // 薪水
    private int salary = 0;

    // 存储下属的List
    private ArrayList<ICorp> subordinateList = new ArrayList<>();

    public Branch(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public void addSubordinate(ICorp corp) {
        this.subordinateList.add(corp);
    }

    @Override
    public ArrayList<ICorp> getSubordinate() {
        return this.subordinateList;
    }

    // 可以利用模板方法优化
    @Override
    public String getInfo() {
        String info = "";
        info = "姓名：" + this.name;
        info = info + "\t职位: " + this.position;
        info = info + "\t薪水: " + this.salary;
        return info;
    }
}
