package com.code.tulip.thinking_in_java.io;

import java.io.*;
import java.util.Random;

/**
 * @Classname Worm
 * @Description 序列化的简单使用
 * @author code-tulip
 * @Date 2019/5/22 10:45 PM
 * @Version 1.0
 */
public class Worm implements Serializable {

    private static Random random = new Random(47);

    private Data[] data = {
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10))
    };

    private Worm next;

    private char c;

    public Worm(int i, char x) {
        System.out.println("Worm constructor: " + i);
        c = x;
        if (--i > 0) {
            next = new Worm(i, (char) (x + 1));
        }
    }

    public Worm() {
        System.out.println("Default Constructor");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(":");
        sb.append(c);
        sb.append("(");
        for (Data d : data) {
            sb.append(d);
        }
        sb.append(")");
        if (next != null) {
            sb.append(next);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Worm w1 = new Worm(6, 'a');
        System.out.println("w1 = " + w1);
        // 写入磁盘文件,序列化
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/code-tulip/testdataset/worm.out"));
        out.writeObject("Worm Storage\n");
        out.writeObject(w1);
        out.close(); // 会清空输出

        // 读取磁盘文件，反序列化
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/code-tulip/testdataset/worm.out"));
        String s = (String) in.readObject();
        Worm w2 = (Worm) in.readObject();
        System.out.println(s + "w2 = " + w2);

        // 序列化会保存对象的"全景图"，可以追踪对象内的所有引用，并且保存那些对象，即对象网

        // 另外一种读写字节数组ByteArray,使用ByteArrayInputStream和ByteArrayOutputStream
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(buf); // 使用缓冲区
        /*
        * 以下其他操作类似
        * */
    }
}

class Data implements Serializable {
    private int n;

    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}