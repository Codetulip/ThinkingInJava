/**
 * FileName: InputFile
 * Author:   Code
 * Date:     2019/5/5 21:59
 * Description: 构造器异常的测试（与Cleanup类一同测试）
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFile {
    private BufferedReader in;

    // 接受一个参数表示文件名
    public InputFile(String fname) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fname));
            // 其他的一些操作（可能导致异常）
        } catch (FileNotFoundException e) {
            System.out.println("could not open " + fname);
            // 没有打开所以不需要关闭
            throw e;
        } catch (Exception e) {
            // 如果是其他的操作引起的异常就需要关闭in了
            try {
                in.close();
            } catch (IOException e1) {
                System.out.println("in.close() not successful!!");
            }
            throw e;
        } finally {
            // 这里就不需要关闭了，因为不确定是否出现了异常，如果正常打开了就不需要关闭了
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            // 将其转化为RuntimeException,表示一个编程错误
            throw new RuntimeException("readline() failed");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close() failed");
        }
    }
}
