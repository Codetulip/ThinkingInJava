package code.designPatterns.bridge;

/**
 * @Classname HouseCorp
 * @Description 房地产公司
 * @Author tujing
 * @Date 2019/6/27 10:34 PM
 * @Version 1.0
 */
public class HouseCorp extends Corp {

    public HouseCorp(Product product) {
        super(product);
    }

    // 房地产公司盖房子
    @Override
    protected void produce() {
        System.out.println("房地产公司盖房子...");
    }

    // 买房子
    @Override
    protected void sell() {
        System.out.println("房地产公司出售房子...");
    }

    // 计算利润
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚大钱了...");
    }
}
