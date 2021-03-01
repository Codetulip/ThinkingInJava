package com.code.tulip.thinking_in_java.designPatterns.adapter;

import java.util.Map;

/**
 * @Classname IOuterUser
 * @Description 外部公司人员信息接口
 * @author code-tulip
 * @Date 2019/6/19 9:33 PM
 * @Version 1.0
 */
public interface IOuterUser {

    // 基本信息
    public Map getUserBaseInfo();

    // 工作区域信息
    public Map getUserOfficeInfo();

    // 用户的家庭信息
    public Map getUserHomeInfo();
}
