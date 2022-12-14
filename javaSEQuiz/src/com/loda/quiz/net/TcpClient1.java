package com.loda.quiz.net;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author loda
 * @Date 2022/10/19 17:59
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class TcpClient1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 60102);

        new Thread(new SendMsg(socket)).start();
        new Thread(new RecvMsg(socket)).start();
    }

}
