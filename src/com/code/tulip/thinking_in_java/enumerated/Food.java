package com.code.tulip.thinking_in_java.enumerated;

/**
 * @Interfacename Food
 * @Description 使用接口组织枚举
 * @author code-tulip
 * @Date 2019/5/23 10:55 PM
 * @Version 1.0
 */

// 有的时候希望枚举类型类似普通类可以继承基类保持基类的属性，又能又有自己的属性
// 比如食物分为小吃、正餐、甜点，各种类又有不同的对象，此时可以采用下面的方法实现
// 对于enum而言，实现接口是使其子类化的唯一办法
public interface Food {

    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;
    }

    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
    }

    enum Dessert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
    }

    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINP, TEA, HERB_TEA;
    }

}
