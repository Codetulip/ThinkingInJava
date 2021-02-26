package com.code.tulip.thinking_in_java.designPatterns.adapter;

import java.util.Map;

/**
 * @Classname OuterUserInfo
 * @Description 适配类
 * @author code-tulip
 * @Date 2019/6/19 9:41 PM
 * @Version 1.0
 */
public class OuterUserInfo extends OuterUser implements IUserInfo {

    // 员工的基本信息
    private Map baseInfo = super.getUserBaseInfo();
    // 员工的家庭信息
    private Map homeInfo = super.getUserHomeInfo();
    // 员工的工作信息
    private Map officeInfo = super.getUserOfficeInfo();

    /**
     * 用户姓名
     * @return
     */
    @Override
    public String getUserName() {
        String userName = (String) this.baseInfo.get("userName");
        System.out.println(userName);
        return userName;
    }

    /**
     * 通话家庭地址
     * @return
     */
    @Override
    public String getHomeAddress() {
        String homeAddress = (String) this.homeInfo.get("homeAddress");
        System.out.println(homeAddress);
        return homeAddress;
    }

    /**
     * 用户手机号码
     * @return
     */
    @Override
    public String getMobileNumber() {
        String mobileNumber = (String) this.baseInfo.get("mobileNumber");
        System.out.println(mobileNumber);
        return mobileNumber;
    }

    /**
     * 办公电话
     * @return
     */
    @Override
    public String getOfficeTelNumber() {
        String officeNumber = (String) this.officeInfo.get("officeTelNumber");
        System.out.println(officeNumber);
        return officeNumber;
    }

    /**
     * 职位信息
     * @return
     */
    @Override
    public String getJobPosition() {
        String jobPosition = (String) this.officeInfo.get("jobPosition");
        System.out.println(jobPosition);
        return jobPosition;
    }

    /**
     * 家庭电话号码
     * @return
     */
    @Override
    public String getHomeTelNumber() {
        String homeTelNumber = (String) this.homeInfo.get("homeTelNumber");
        System.out.println(homeTelNumber);
        return homeTelNumber;
    }
}
