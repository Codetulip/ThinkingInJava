package code.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Classname EchoServer
 * @Description
 * @Author codetulip
 * @Date 2019/8/12 21:59
 * @Version 1.0
 */
public class EchoServer {

    public static void main(String[] args) throws IOException {
        // 建立serverSocket
        ServerSocket serverSocket = new ServerSocket(9999);
        // 等待连接
        Socket client = serverSocket.accept();
        InputStream inputStream = client.getInputStream();
        OutputStream outputStream = client.getOutputStream();
        Scanner scanner = new Scanner(inputStream);
        try {
            scanner.useDelimiter("\n");
            PrintStream out = new PrintStream(outputStream);

            // 输出客服端输入
            boolean flag = false; // 指示是否输入完毕
            while (!flag && scanner.hasNext()) {
                String line = scanner.nextLine();
                out.println("Echo:" + line);
                if (line.trim().equals("bye")) {
                    flag = true;
                }
            }
        } finally {
            scanner.close();
            outputStream.close();
            inputStream.close();
            client.close();
        }
    }
}
