package code.designPatterns.observer.universalCode;

/**
 * @Classname ClientXY
 * @Description
 * @Author codetulip
 * @Date 2019/7/6 16:07
 * @Version 1.0
 */
public class ClientXY {

    public static void main(String[] args) {
        X x = new X();
        // 添加观察者
        x.addObserver(new Y());
        // 改变
        x.change();

        /**
         * 观察结果会发现自动触发了Observer的update()方法
         */

    }
}
