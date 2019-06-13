package code.designPatterns.prototype;

/**
 * @Classname Mail
 * @Description 邮件类代码克隆
 * @Author tujing
 * @Date 2019/6/13 4:08 PM
 * @Version 1.0
 */
public class MailClone implements Cloneable {

    // 收件人
    private String receiver;

    // 邮件名称
    private String subject;

    // 称谓
    private String appellation;

    // 邮件内容
    private String context;

    // 邮件的尾部，一般都加上"XXX版权所有"等信息
    private String tail;

    // 构造函数
    public MailClone(AdvTemplate advTemplate) {
        this.context = advTemplate.getAdvContext();
        this.subject = advTemplate.getAdvSubject();
        System.out.println("我是构造器"); // 你会发现只输出一次，因为clone()不会经过构造器，而是直接拷贝创建一个对象
    }

    @Override
    public MailClone clone() {
        MailClone mail = null;
        try {
            mail = (MailClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mail;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
