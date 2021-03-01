package com.code.tulip.thinking_in_java.io.xfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @Classname ThawAlien
 * @Description 反序列化Alien
 * @author code-tulip
 * @Date 2019/5/22 11:23 PM
 * @Version 1.0
 */
public class ThawAlien {

    // 必须保证Java虚拟机能找到相关的.class文件
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/code-tulip/testdataset/x.file"));
        Object mystery = in.readObject(); //会调用顶层基类（非Object）构造器
        System.out.println(mystery.getClass() + " " + mystery.getClass().getSimpleName());

    }
}
