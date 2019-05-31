package code.io;

import java.io.Serializable;

/**
 * @Classname Alien
 * @Description 作为测试不同包序列化和反序列的基类
 * @Author tujing
 * @Date 2019/5/22 11:21 PM
 * @Version 1.0
 */
public class Alien implements Serializable {

    //第一非序列化的超类必须具有无参构造器，否则会出现InvalidClassException
    public Alien() {
        System.out.println("Alien无参构造器");
    }

    public Alien(int n) {
        System.out.println("Alien n");
    }

    public static int i = 1;
}
