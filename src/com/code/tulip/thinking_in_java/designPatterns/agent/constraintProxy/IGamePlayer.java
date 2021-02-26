package com.code.tulip.thinking_in_java.designPatterns.agent.constraintProxy;

/**
 * @Interfacename IGamePlayer
 * @Description 强制代理的接口类
 * @author code-tulip
 * @Date 2019/6/12 11:38 PM
 * @Version 1.0
 */
public interface IGamePlayer {

    // 登录游戏
    public void login(String user, String password);

    // 杀怪
    public void killBoss();

    // 升级
    public void upgrade();

    // 每个人都可以找一下自己的代理
    public IGamePlayer getProxy();
}
