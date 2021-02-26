package com.code.tulip.thinking_in_java.designPatterns.prototype;

/**
 * @Classname AdvTemplate
 * @Description 广告信模板代码
 * @author code-tulip
 * @Date 2019/6/13 4:05 PM
 * @Version 1.0
 */
public class AdvTemplate {
    // 广告信名称
    private String advSubject = "XX银行国庆信用卡抽奖活动";

    // 广告信内容
    private String advContext = "国庆抽奖活动通知：只要刷卡就送你一百万！...";

    // 取得广告信名称
    public String getAdvSubject() {
        return this.advSubject;
    }

    // 取得广告信的内容
    public String getAdvContext() {
        return this.advContext;
    }

}
