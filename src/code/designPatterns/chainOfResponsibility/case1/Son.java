package code.designPatterns.chainOfResponsibility.case1;

/**
 * @Classname Husband
 * @Description 处理类3
 * @Author tujing
 * @Date 2019/7/2 10:29 PM
 * @Version 1.0
 */
public class Son implements IHandler{
    // 请示儿子
    @Override
    public void handleMessage(IWomen women) {
        System.out.println("母亲的请示是:" + women.getRequest());
        System.out.println("儿子的答复是：同意");
    }
}
