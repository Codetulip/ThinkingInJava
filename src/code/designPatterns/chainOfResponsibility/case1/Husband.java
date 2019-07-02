package code.designPatterns.chainOfResponsibility.case1;

/**
 * @Classname Husband
 * @Description 处理类2
 * @Author tujing
 * @Date 2019/7/2 10:29 PM
 * @Version 1.0
 */
public class Husband implements IHandler{
    // 请示丈夫
    @Override
    public void handleMessage(IWomen women) {
        System.out.println("妻子的请示是:" + women.getRequest());
        System.out.println("丈夫的答复是：同意");
    }
}
