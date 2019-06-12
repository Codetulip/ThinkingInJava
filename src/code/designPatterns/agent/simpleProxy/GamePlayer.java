package code.designPatterns.agent.simpleProxy;

/**
 * @Classname GamePlayer
 * @Description 游戏者
 * @Author tujing
 * @Date 2019/6/12 10:56 PM
 * @Version 1.0
 */
public class GamePlayer implements IGamePlayer {

    private String name = ""; // 游戏角色名

    // 通过构造函数传递名称
    public GamePlayer(String _name) {
        this.name = _name;
    }

    @Override

    public void login(String user, String password) {
        System.out.println("登录名为" + user + "的用户" + this.name + "登录成功！");
    }

    @Override
    public void killBoss() {
        System.out.println(this.name + "在打怪！");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name + " 升级了！");
    }
}
