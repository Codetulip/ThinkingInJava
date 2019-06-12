package code.designPatterns.agent.dynamicProxy;

import code.designPatterns.agent.simpleProxy.GamePlayer;
import code.designPatterns.agent.simpleProxy.IGamePlayer;

import java.lang.reflect.Proxy;

/**
 * @Classname Client
 * @Description 动态代理的场景类
 * @Author tujing
 * @Date 2019/6/13 12:09 AM
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        // 定义玩家
        IGamePlayer player = new GamePlayer("张三");
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(
                player.getClass().getClassLoader(), // 类加载器
                new Class[]{IGamePlayer.class}, // 代理需要实现的接口
                new GamePlayIH(player) // InvocationHandler实现类
        );
        // 登录
        proxy.login("zhangsan", "password");
        // 开始打怪
        proxy.killBoss();
        // 升级
        proxy.upgrade();
    }
}
