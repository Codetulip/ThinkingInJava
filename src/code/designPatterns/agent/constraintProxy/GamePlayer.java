package code.designPatterns.agent.constraintProxy;

/**
 * @Classname GamePlayer
 * @Description 强制代理的真实角色
 * @Author tujing
 * @Date 2019/6/12 11:39 PM
 * @Version 1.0
 */
public class GamePlayer implements IGamePlayer {

    private String name = ""; // 游戏角色名

    // 我的代理
    private IGamePlayer proxy = null;

    // 通过构造函数传递名称
    public GamePlayer(String _name) {
        this.name = _name;
    }

    @Override
    public void login(String user, String password) {
        if (this.isProxy()) {
            System.out.println("登录名为" + user + "的用户" + this.name + "登录成功！");
        } else {
            System.out.println("请使用指定代理访问");
        }

    }

    @Override
    public void killBoss() {
        if (this.isProxy()) {
            System.out.println(this.name + "在打怪！");
        } else {
            System.out.println("请使用指定代理访问");
        }
    }

    @Override
    public void upgrade() {
        if (this.isProxy()) {
            System.out.println(this.name + " 升级了！");
        } else {
            System.out.println("请使用指定代理访问");
        }
    }

    @Override
    public IGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    // 检查是否是代理访问
    private boolean isProxy() {
        if (this.proxy == null) {
            return false;
        } else {
            return true;
        }
    }
}
