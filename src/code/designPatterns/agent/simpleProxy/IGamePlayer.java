package code.designPatterns.agent.simpleProxy;

/**
 * @Interfacename IGamePlayer
 * @Description 游戏者接口
 * @Author tujing
 * @Date 2019/6/12 10:54 PM
 * @Version 1.0
 */
public interface IGamePlayer {

    // 登录游戏
    public void login(String user, String password);

    // 杀怪
    public void killBoss();

    // 升级
    public void upgrade();
}
