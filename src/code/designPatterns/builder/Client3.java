package code.designPatterns.builder;

/**
 * @Classname Client3
 * @Description 场景类3
 * @Author tujing
 * @Date 2019/6/11 12:23 AM
 * @Version 1.0
 */
public class Client3 {

    public static void main(String[] args) {
        /**
         * 建造者模式将复杂对象的构建与它的表示分离，使得同样的构建过程可以产生不同的表示
         */
        DirectorForCar director = new DirectorForCar();
        // 生产A类奔驰车
        director.getABenzModel();
        // 生产B类奔驰车
        director.getBBenzModel();
    }
}
