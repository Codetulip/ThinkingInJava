package code.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Classname FreezeAlien
 * @Description 序列化Alien
 * @Author tujing
 * @Date 2019/5/22 11:21 PM
 * @Version 1.0
 */
public class FreezeAlien {

    public static void main(String[] args) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/tujing/testdataset/x.file"));
        AlienExtend quellek = new AlienExtend();
        out.writeObject(quellek);
    }
}
