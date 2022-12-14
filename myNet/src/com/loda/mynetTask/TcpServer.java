package com.loda.mynetTask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现基于TCP协议的Socket服务器端编程：设服务器端程序监听端口为8629，可监听并处理多个客户请求。
 * 当收到客户端信息后，会开启一个新的线程来处理客户的请求。
 * 该线程首先判断是否是“BYE”，若是，则立即向对方发送“BYE”，并结束该线程。
 * 若不是，则在屏幕上输出收到的信息，并由键盘上输入发送到对方的应答信息。
 */

public class TcpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(60101);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                socket = serverSocket.accept();
//                new Thread(new ServerReadMsg(socket)).start();
                new Thread(new ServerSendMsg(socket)).start();
                new Thread(new ServerReadTackleMsg(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
