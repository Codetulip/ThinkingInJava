package com.code.tulip.thinking_in_java.designPatterns.adapter;

/**
 * @Classname UserInfo
 * @Description
 * @author code-tulip
 * @Date 2019/6/19 9:27 PM
 * @Version 1.0
 */
public class UserInfo implements IUserInfo {
    @Override
    public String getUserName() {
        System.out.println("姓名是...");
        return null;
    }

    @Override
    public String getHomeAddress() {
        System.out.println("员工的家庭地址");
        return null;
    }

    @Override
    public String getMobileNumber() {
        System.out.println("这个人的手机号是...");
        return null;
    }

    @Override
    public String getOfficeTelNumber() {
        System.out.println("这个人的办公室电话是");
        return null;
    }

    @Override
    public String getJobPosition() {
        System.out.println("这个人的公司职位是..");
        return null;
    }

    @Override
    public String getHomeTelNumber() {
        System.out.println("员工的家庭电话是...");
        return null;
    }
}
