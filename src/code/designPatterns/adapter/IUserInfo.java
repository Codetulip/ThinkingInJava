package code.designPatterns.adapter;

/**
 * @Interfacename IUerInfo
 * @Description  员工信息接口
 * @Author tujing
 * @Date 2019/6/19 9:23 PM
 * @Version 1.0
 */
public interface IUserInfo {

    // 获得用户姓名
    public String getUserName();

    // 获得家庭地址
    public String getHomeAddress();

    // 手机号码
    public String getMobileNumber();

    // 办公电话
    public String getOfficeTelNumber();

    // 职位
    public String getJobPosition();

    // 获得家庭电话
    public String getHomeTelNumber();

}
