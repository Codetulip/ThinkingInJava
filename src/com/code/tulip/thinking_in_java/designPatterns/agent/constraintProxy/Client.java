package com.code.tulip.thinking_in_java.designPatterns.agent.constraintProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname Client1
 * @Description 强制代理的场景类
 * @author code-tulip
 * @Date 2019/6/12 11:46 PM
 * @Version 1.0
 */

// 强制代理不允许直接访问真实角色
public class Client {

    public static void main(String[] args) {
        // 定义一个玩家
        IGamePlayer player = new GamePlayer("张三");
        // 定义一个代理
//        IGamePlayer proxy = new GamePlayerProxy1(player); // 此时还是无法运行，你必须获得指定的代理才行
        IGamePlayer proxy = player.getProxy();
        // 开始游戏，记下时间戳
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间是:" + format.format(new Date()));
        proxy.login("zhangsan", "password");
        // 开始杀怪
        proxy.killBoss();
        // 升级
        proxy.upgrade();
        // 记录结束游戏时间
        System.out.println("结束时间是:" + format.format(new Date()));
    }
}
