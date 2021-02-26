package com.code.tulip.thinking_in_java.designPatterns.agent.simpleProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname Client
 * @Description 普通代理的场景类
 * @author code-tulip
 * @Date 2019/6/12 11:00 PM
 * @Version 1.0
 */

// 调用者只知代理而不用知道具体角色是谁，屏蔽了具体角色的变更对高层模块的影响
public class Client {

    public static void main(String[] args) {
        // 定义一个玩家
        IGamePlayer player = new GamePlayer("张三");
        // 开始游戏，记下时间戳
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间是:" + format.format(new Date()));
        player.login("zhangsan", "password");
        // 开始杀怪
        player.killBoss();
        // 升级
        player.upgrade();
        // 记录结束游戏时间
        System.out.println("结束时间是:" + format.format(new Date()));
    }
}
