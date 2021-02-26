package com.code.tulip.thinking_in_java.designPatterns.priciple.lawOfDemeter;

import java.util.List;

/**
 * @Classname GroupLeader
 * @Description 委员，负责清点女生人数
 * @author code-tulip
 * @Date 2019/6/5 3:54 PM
 * @Version 1.0
 */
public class GroupLeader {

    private List<Girl> list;

    public GroupLeader(List<Girl> list) {
        this.list = list;
    }

    // 清点女生人数
   /* // point 1
    public void countGirls(List<Girl> list) {
        System.out.println("女生数量是:" + list.size());
    }*/

    // point 2
    public void countGirls() {
        System.out.println("女生数量是:" + list.size());
    }
}
