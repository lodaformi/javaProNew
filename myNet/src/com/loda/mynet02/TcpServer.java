package com.loda.mynet02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(60101);
        Socket socket = serverSocket.accept();

        new Thread(new SendMsg(socket)).start();
        new Thread(new RecvMsg(socket)).start();

        if (socket.isClosed()) {
            serverSocket.close();
        }
    }
}
