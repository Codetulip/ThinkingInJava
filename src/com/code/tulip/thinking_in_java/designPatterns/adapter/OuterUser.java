package com.code.tulip.thinking_in_java.designPatterns.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname OuterUser
 * @Description 外部公司人员实现
 * @author code-tulip
 * @Date 2019/6/19 9:34 PM
 * @Version 1.0
 */

// 你会发现两个公司的信息员工信息的存储方式相差很多，但是必须进行交互
// 于是考虑中间加一层转换处理(中转类OuterUserInfo)
public class OuterUser implements IOuterUser {

    /**
     * 用户的基本信息
     *
     * @return
     */
    @Override
    public Map getUserBaseInfo() {
        HashMap baseInfoMap = new HashMap();
        baseInfoMap.put("userName", "姓名为...");
        baseInfoMap.put("mobileNumber", "员工电话是...");
        return baseInfoMap;
    }

    /**
     * 用户的家庭
     *
     * @return
     */
    @Override
    public Map getUserOfficeInfo() {
        HashMap homeInfo = new HashMap();
        homeInfo.put("homeTelNumber", "员工的家庭电话是...");
        homeInfo.put("homeAddress", "员工的家庭地址是...");
        return homeInfo;
    }


    /**
     * 用户的工作信息
     *
     * @return
     */
    @Override
    public Map getUserHomeInfo() {
        HashMap officeInfo = new HashMap();
        officeInfo.put("jobPosition", "这个人的职位是...");
        officeInfo.put("officeTelNumber", "员工的办公室电话是...");
        return officeInfo;
    }
}
