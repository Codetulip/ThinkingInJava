package code.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @Classname TransferTo
 * @Description 利用TransferTo或者TransferFrom连接两个通道
 * @Author tujing
 * @Date 2019/5/22 2:54 PM
 * @Version 1.0
 */
public class TransferTo {

    public static void main(String[] args) throws Exception{
        if (args.length != 2) {
            System.out.println("arguments: sourceFile destFile");
            System.exit(1);
        }
        FileChannel
                in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
        //或者
//        out.transferFrom(in, 0, in.size());
    }
}
