/**
 * FileName: UsingRandowAccessFile
 * Author:   Code
 * Date:     2019/5/16 21:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.io;

import java.io.IOException;
import java.io.RandomAccessFile;

// RandomAccessFile类似组合了DataInputStream和DataOutputStream
public class UsingRandowAccessFile {
    static String file = "C:\\Users\\Code\\Desktop\\code.txt"; // 存放文件路径

    public static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++ )
            rf.writeDouble(i*1.414);
        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        // 设置从文件开头开始的偏移量，从该位置开始下一次读取或写入
        rf.seek(5*8);  // Double为8个字节
        rf.writeDouble(47.001);
        rf.close();
        display();
    }
}
