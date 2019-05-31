package code.io;

import java.io.*;

/**
 * @Classname Blips
 * @Description 测试Externalizable，序列化的控制
 * @Author tujing
 * @Date 2019/5/23 9:42 AM
 * @Version 1.0
 */

class Blip1 implements Externalizable {

    public Blip1() {
        System.out.println("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1 writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1 readExternal");
    }
}

class Blip2 implements Externalizable {

    // 此时构造器必须是public的，和Serializable不太一样
    public Blip2() {
        System.out.println("Blip2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2 writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2 readExternal");
    }
}

public class Blips {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects");
        Blip1 blip1 = new Blip1();
        Blip2 blip2 = new Blip2();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/tujing/testdataset/Blips.out"));
        System.out.println("序列化对象: ");
        out.writeObject(blip1); // 自动调用writeExternal方法
        out.writeObject(blip2);
        out.close();

        //反序列化
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/tujing/testdataset/Blips.out"));
        System.out.println("反序列化对象: ");
        // 不具备public构造器此处会异常
        Blip1 o1 = (Blip1) in.readObject(); // 先调用无参构造器(没有会异常)，然后执行readExternal方法
        Blip2 o2 = (Blip2) in.readObject();
    }
}
