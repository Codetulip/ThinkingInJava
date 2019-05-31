package code.designPatterns.factory.product;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ProductFactory
 * @Description 延迟初始化
 * @Author tujing
 * @Date 2019/5/22 12:19 AM
 * @Version 1.0
 */
public class ProductFactory {

    private static Map<String, Product> prMap = new HashMap<String, Product>();

    // 等到要使用的时候取出来
    public static synchronized Product createProduct(String type) {
        Product product = null;
        if (prMap.containsKey(type)) {
            product = prMap.get(type);
        } else {
            if (type.equals("ConcreteProduct1")) {
                product = new ConcreteProduct1();
            } else {
                product = new ConcreteProduct2();
            }
            // 同时把新创建的对象放到缓存容器中
            prMap.put(type, product);
        }
        return product;
    }
}
