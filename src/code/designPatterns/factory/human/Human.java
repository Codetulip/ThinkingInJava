package code.designPatterns.factory.human;

/**
 * @Interfacename Human
 * @Description 人类总称
 * @Author tujing
 * @Date 2019/5/21 9:32 PM
 * @Version 1.0
 */
public interface Human {

    // 每个人种都有相应的颜色
    public void getColor();

    // 人类会说话
    public void talk();
}
