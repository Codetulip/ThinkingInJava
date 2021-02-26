/**
 * FileName: OSExecute
 * @author:   Code
 * Date:     2019/5/17 14:17
 * Description: 接收command字符串作为指令并执行，获得指令返回信息
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSExecute {

    /**
     * 接收command字符串作为指令并执行，获得指令返回信息
     * @param command 指令字符串
     */
    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            // process执行后，内存将输出信息给process，这就是process的输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            // 输出process的输入流到控制台
            while ((s = br.readLine()) != null) {
                System.out.println(s); // 此处可将信息存储在List中
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            // 输出process的错误流到控制台
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (Exception e) {
            if (!(command.startsWith("CMD /C"))) {
                command("CMD /C" + command);
            } else {
                throw new RuntimeException(e);
            }
        }
        if (err) {
            throw new OSExecuteException("Errors executing " + command);
        }
    }
}

class OSExecuteDemo {

    public static void main(String[] args) {
        OSExecute.command("ls -l");
    }
}
