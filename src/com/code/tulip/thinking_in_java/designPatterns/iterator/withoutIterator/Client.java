package com.code.tulip.thinking_in_java.designPatterns.iterator.withoutIterator;

import java.util.ArrayList;

/**
 * @Classname Client
 * @Description
 * @author code-tulip
 * @Date 2019/6/16 2:27 PM
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        // 定义有个List，存放所有的项目对象
        ArrayList<IProject> projectList = new ArrayList<>();
        // 增加几个项目
        projectList.add(new Project("星球大战项目", 10, 10000));
        projectList.add(new Project("扭转时空项目", 100, 1000000));
        projectList.add(new Project("超人改造项目", 10000, 100000));
        // 随便增加更多的项目
        for (int i = 4; i < 104; i++) {
            projectList.add(new Project("第" + i + "个项目", i * 5, i * 10000));
        }
        // 遍历list取出所有项目信息
        for (IProject project : projectList) {
            System.out.println(project.getProjectInfo());
        }
    }
}
