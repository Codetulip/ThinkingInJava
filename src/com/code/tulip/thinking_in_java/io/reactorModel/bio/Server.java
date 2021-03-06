package com.code.tulip.thinking_in_java.io.reactorModel.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Classname Server
 * @Description 传统的BIO模型
 * @author codetulip
 * @Date 2019/10/15 15:18
 * @Version 1.0
 */

/**
 * 对于每一个请求都分发给一个线程，每个线程中都独自处理上面的流程。
 * 这种模型由于IO在阻塞时会一直等待，因此在用户负载增加时，性能下降的非常快。
 *
 * server导致阻塞的原因：
 * 1、serversocket的accept方法，阻塞等待client连接，直到client连接成功。
 * 2、线程从socket inputstream读入数据，会进入阻塞状态，直到全部数据读完。
 * 3、线程向socket outputstream写入数据，会阻塞直到全部数据写完。
 *
 * client导致阻塞的原因：
 * 1、client建立连接时会阻塞，直到连接成功。
 * 2、线程从socket输入流读入数据，如果没有足够数据读完会进入阻塞状态，直到有数据或者读到输入流末尾。
 * 3、线程从socket输出流写入数据，直到输出所有数据。
 * 4、socket.setsolinger()设置socket的延迟时间，当socket关闭时，会进入阻塞状态，直到全部数据都发送完或者超时。
 *
 * 改进：采用基于事件驱动的设计，当有事件触发时，才会调用处理器进行数据处理。
 */
public class Server implements Runnable {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (!Thread.interrupted()) {
                // 创建新的线程处理
                new Thread(new Handler(serverSocket.accept())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class Handler implements Runnable {
        final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                byte[] input = new byte[1024];
                socket.getInputStream().read(input);
                byte[] output = process(input);
                socket.getOutputStream().write(output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 处理数据的方法
         *
         * @param input
         * @return
         */
        private byte[] process(byte[] input) {
            return null;
        }
    }
}
