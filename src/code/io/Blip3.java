package code.io;

import java.io.*;

/**
 * @Classname Blip3
 * @Description 实现Externalizable接口完整的序列化和反序列化
 * @Author tujing
 * @Date 2019/5/23 10:33 AM
 * @Version 1.0
 */

// 实现此接口的类在序列化过程中自动调用writeExternal
// 在反序列化过程中，会首先调用类的默认构造器和类中所有对象的默认构造器，然后才调用readExternal
public class Blip3 implements Externalizable {

    private int i;

    private String s; // i和s都没初始化

    public Blip3() {
        System.out.println("Blip3无参构造器");
    }

    // i和s在非默认构造器中初始化
    public Blip3(int i, String s) {
        System.out.println("Blip3有参构造器");
        this.i = i;
        this.s = s;
    }

    public String toString() {
        return s + i;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3 writeExternal");
        // 必须这样写,反序列化的时候会默认调用无参构造器，此时就不会初始化i和s,因此要在将i和s的信息序列化
        out.writeInt(i);
        out.writeObject(s);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3 readExternal");
        // 必须这样写，反序列化的时候会首先默认调用无参构造器，此时就不会初始化i和s,因此要在这里初始化
        i = in.readInt();
        s = (String) in.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("constructing objects: ");
        Blip3 blip3 = new Blip3(2, "sss");
        System.out.println(blip3);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/tujing/testdataset/Blip3.out"));
        System.out.println("序列化对象：");
        out.writeObject(blip3); // 将out传给writeExternal方法的参数
        out.close();

        // 反序列化
        System.out.println("反序列化对象: ");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/tujing/testdataset/Blip3.out"));
        blip3 = (Blip3) in.readObject(); // 先调用无参构造器，再调用readExternal方法，将in传给readExternal方法的参数
        System.out.println(blip3);
    }
}
