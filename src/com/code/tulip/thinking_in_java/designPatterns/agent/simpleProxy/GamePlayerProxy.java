package com.code.tulip.thinking_in_java.designPatterns.agent.simpleProxy;

/**
 * @Classname GamePlayerProxy
 * @Description
 * @author code-tulip
 * @Date 2019/6/12 11:10 PM
 * @Version 1.0
 */
public class GamePlayerProxy implements IGamePlayer {

    private IGamePlayer player = null;

    // 通过构造函数传递被代理的对象
    public GamePlayerProxy(IGamePlayer player) {
        this.player = player;
    }

    @Override
    public void login(String user, String password) {
        this.player.login(user, password);
    }

    @Override
    public void killBoss() {
        this.player.killBoss();
    }

    @Override
    public void upgrade() {
        this.player.upgrade();
    }
}
