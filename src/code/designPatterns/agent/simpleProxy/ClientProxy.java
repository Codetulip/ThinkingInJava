package code.designPatterns.agent.simpleProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname ClientProxy
 * @Description 代理后的场景类
 * @Author tujing
 * @Date 2019/6/12 11:12 PM
 * @Version 1.0
 */
public class ClientProxy {


    public static void main(String[] args) {
        // 定义一个玩家
        IGamePlayer player = new GamePlayer("张三");
        // 定义一个代理
        IGamePlayer proxy = new GamePlayerProxy(player);
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
