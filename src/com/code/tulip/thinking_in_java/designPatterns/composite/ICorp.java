package com.code.tulip.thinking_in_java.designPatterns.composite;

/**
 * @Interfacename ICorp
 * @Description 公司员工接口
 * @author code-tulip
 * @Date 2019/6/16 8:52 PM
 * @Version 1.0
 */
// 将对象组合成树形结构以表示"部分-整体"的层次结构，使得用户对单个对象和组合对象的使用具有一致性。
public interface ICorp {

    // 获取员工信息
    public String getInfo();

}
