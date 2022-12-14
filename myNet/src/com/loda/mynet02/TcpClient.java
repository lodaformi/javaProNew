package com.loda.mynet02;

import java.io.IOException;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 60101);

        new Thread(new RecvMsg(socket)).start();
        new Thread(new SendMsg(socket)).start();
    }
}
