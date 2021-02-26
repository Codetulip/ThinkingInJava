/**
 * FileName: Hero
 * @author:   Code
 * Date:     2019/4/24 20:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.interfaces.multipleInterfaces;

class ActionCharacter {

    public void fight() {
        System.out.println("ActionCharacter fight");
    } // 当作是实现了CanFight接口中的方法

}


public class Hero extends ActionCharacter implements CanFight,CanFly,CanSwim {
    @Override
    public void fly() {
        System.out.println("fly");
    }

    @Override
    public void swim() {

        System.out.println("swim");
    }

    public static void t(CanFight x) {x.fight();}
    public static void u(CanSwim x) {x.swim();}
    public static void v(CanFly x) {x.fly();}
    public static void w(ActionCharacter x) {x.fight();}


    public static void main(String[] args) {
        Hero h = new Hero();
        t(h);u(h);v(h);w(h);
    }
}
