package com.code.tulip.thinking_in_java.designPatterns.priciple.lawOfDemeter;

/**
 * @Classname Teacher
 * @Description 老师让委员清点女生人数
 * @author code-tulip
 * @Date 2019/6/5 3:53 PM
 * @Version 1.0
 */
public class Teacher {

    // 下达指令的函数
    /*// point 1
    public void commond(GroupLeader groupLeader) {
        List<Girl> list = new ArrayList<Girl>(); //Girl并不是朋友类，但是Teacher与它有了"交流"
        // 初始化女生
        for (int i = 0; i < 10; i++) {
            list.add(new Girl());
        }
        // 执行清点操作
        groupLeader.countGirls(list);
    }*/

    // point 2
    public void commond(GroupLeader groupLeader) {
        // 执行清点操作
        groupLeader.countGirls(); // 可见这种方式避免了与非朋友类的交流
    }
}
