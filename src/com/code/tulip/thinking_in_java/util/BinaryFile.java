/**
 * FileName: BinaryFile
 * @author:   Code
 * Date:     2019/5/16 23:19
 * Description: 读取二进制文件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryFile {

    public static byte[] read(File file) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] data = new byte[bf.available()];
            bf.read(data); // 将读取到的数据放入指定数组
            return data;
        } finally {
            bf.close();
        }
    }

    public static byte[] read(String filename) throws IOException {
        return read(new File(filename).getAbsoluteFile());
    }
}
