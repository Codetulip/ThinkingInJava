package code.designPatterns.builder.universalCode;

/**
 * @Classname Builder
 * @Description 抽象建造者
 * @Author tujing
 * @Date 2019/6/11 12:32 AM
 * @Version 1.0
 */
public abstract class Builder {

    // 设置产品的不同表示
    public abstract void setPart();

    // 完成产品的建造
    public abstract Product buildProduct();
}
