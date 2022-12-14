package com.loda.quiz.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author loda
 * @Date 2022/10/19 17:42
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class TcpServer {
    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(60102);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                Socket socket = ss.accept();
//                if (socket == null) {
//                    break;
//                }
                new Thread(new TackleMsg(socket)).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //如果上面退出while循环，则表示socket为空，
//        try {
//            ss.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
