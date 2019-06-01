package code.designPatterns.abstractFactory;

/**
 * @Interfacename Human
 * @Description 人种接口
 * @Author tujing
 * @Date 2019/6/1 11:03 PM
 * @Version 1.0
 */
public interface Human {

    // 每个人都有相应的肤色
    public void getColor();

    // 人类会说话
    public void talk();

    // 每个人都有性别
    public void getSex();

}
