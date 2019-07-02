package code.designPatterns.chainOfResponsibility.case1;

/**
 * @Classname Father
 * @Description 处理类1
 * @Author tujing
 * @Date 2019/7/2 10:27 PM
 * @Version 1.0
 */
public class Father implements IHandler {
    // 请示父亲
    @Override
    public void handleMessage(IWomen women) {
        System.out.println("女儿的请示是：" + women.getRequest());
        System.out.println("父亲的回答是：同意" );
    }
}
