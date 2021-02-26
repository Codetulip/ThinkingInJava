package com.code.tulip.thinking_in_java.designPatterns.prototype;

import java.util.Random;

/**
 * @Classname Client
 * @Description 场景类
 * @author code-tulip
 * @Date 2019/6/13 4:11 PM
 * @Version 1.0
 */

// 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象
public class Client {

    // 发送邮件数量，这个值是从数据库中获得的
    private static int MAX_COUNT = 6;

    public static void main(String[] args) {
        // 模拟发送邮件
        int i = 0;
        // 把模板定义出来，这个是从数据库中获得的
//        Mail mail = new Mail(new AdvTemplate());
        MailClone mail = new MailClone(new AdvTemplate());
        mail.setTail("XX银行版权所有");
        while (i < MAX_COUNT) {
            // 以下是每封邮件不同的地方
            MailClone mailClone = mail.clone();
            mailClone.setAppellation(getRandString(5) + " 先生（女士)");
            mailClone.setReceiver(getRandString(5) + "@" + getRandString(8)
            + ".com");
            sendMail(mailClone);
            i++;
        }
    }

    // 发送邮件
    public static void sendMail(MailClone mail) {
        System.out.println("标题：" + mail.getSubject() + "\t收件人：" + mail.getReceiver() + "\t...发送成功");
    }

    // 获得指定长度的随机字符串
    public static String getRandString(int maxLength) {
        String source = "aldjaoihdaoisdjnklasndasljndlasdkasn";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < maxLength; i++) {
            sb.append(source.charAt(random.nextInt(source.length())));
        }
        return sb.toString();
    }
}
