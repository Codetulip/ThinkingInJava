package com.code.tulip.thinking_in_java.designPatterns.iterator.withIterator;

/**
 * @Classname Client
 * @Description
 * @author code-tulip
 * @Date 2019/6/16 2:55 PM
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        // 定义一个project
        IProject project = new Project();
        // 增加几个项目
        project.add("星球大战项目", 10, 10000);
        project.add("扭转时空项目", 100, 1000000);
        project.add("超人改造项目", 10000, 100000);
        // 随便增加更多的项目
        for (int i = 4; i < 104; i++) {
            project.add("第" + i + "个项目", i * 5, i * 10000);
        }
        // 遍历list取出所有项目信息
        IProjectIterator projectIterator = project.iterator();
        while (projectIterator.hasNext()) {
            IProject p = (IProject) projectIterator.next();
            System.out.println(p.getProjectInfo());
        }
    }
}
