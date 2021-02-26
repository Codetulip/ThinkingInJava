package com.code.tulip.thinking_in_java.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Classname EchoClient
 * @Description
 * @author codetulip
 * @Date 2019/8/12 22:06
 * @Version 1.0
 */
public class EchoClient {

    // 键盘输入流
    public static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 创建客服端，绑定地址和端口号
        Socket client = new Socket("localhost", 9999);
        // 接收服务端传过来的消息
        Scanner scanner = new Scanner(client.getInputStream());
        // 向服务端发送消息
        PrintStream out = new PrintStream(client.getOutputStream(), true);
        boolean flag = false;
        while (!flag) {
            String input = getInputString("请输入要发送的内容: ");
            // 将输入的信息传送给服务端
            out.println(input);
            if (scanner.hasNext()) {
                String var = scanner.next();
                System.out.println(var);
            }
            if ("bye".equalsIgnoreCase(input)) {
                flag = true;
            }
        }
        out.close();
        scanner.close();
        client.close();
    }

    public static String getInputString(String prompt) throws IOException {
        System.out.println(prompt);
        String str = KEYBOARD_INPUT.readLine();
        return str;
    }
}
