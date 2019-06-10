package code.designPatterns.builder.universalCode;

/**
 * @Classname ConcreteProduct
 * @Description 具体建造者
 * @Author tujing
 * @Date 2019/6/11 12:33 AM
 * @Version 1.0
 */
public class ConcreteProduct extends Builder {

    private Product product = new Product();

    @Override
    public void setPart() {
        /**
         * 产品类的组装顺序逻辑处理
         */
    }

    @Override
    public Product buildProduct() {
        return this.product;
    }
}
