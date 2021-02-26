package com.code.tulip.thinking_in_java.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Classname FreezeAlien
 * @Description 序列化Alien
 * @author code-tulip
 * @Date 2019/5/22 11:21 PM
 * @Version 1.0
 */
public class FreezeAlien {

    public static void main(String[] args) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/code-tulip/testdataset/x.file"));
        AlienExtend quellek = new AlienExtend();
        out.writeObject(quellek);
    }
}
