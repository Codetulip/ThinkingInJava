package code.io;

import java.io.*;
import java.util.Date;

/**
 * @Classname Lofin
 * @Description 使用transient关键词进行序列化控制
 * @Author tujing
 * @Date 2019/5/23 1:31 PM
 * @Version 1.0
 */
// 数据一经序列化处理，存入文件或者或者网络IO，就可以通过读取文件或拦截网络信息访问（即使）是private信息
// 所以需要序列化控制，第一种是使用Externalizable(继承自Serializable)，第二种是使用transient关键词
// 第三种方式就是手动添加（是添加而不是覆盖或者实现）writeObject（ObjectOutputStream out）和readObject(ObjectInputStream in)方法
public class Login implements Serializable{

    private Date date = new Date();

    private String username; // 用户名

    private transient String password; // 密码，不希望序列化

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "login info: \n username: " + username + " \n date: "
                + date + "\n password: " + password;
    }

    // 只要提供了这两种方法，序列化的时候就会使用它们而不是默认的序列化机制
    /*private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // 也可以在内部声明使用默认的序列化机制，且必须是第一个操作
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }*/
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Login a = new Login("code", "code");
        System.out.println(a);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/tujing/testdataset/Login.txt"));
        out.writeObject(a); // 会利用反射来检查a所代表的类有没有自己的writeObject方法
        out.close();

        // 反序列化回来
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/tujing/testdataset/Login.txt"));
        a = (Login) in.readObject(); // 会利用反射来检查a所代表的类有没有自己的readObject方法
        System.out.println(a); // 此时会发现password为null
    }
}
