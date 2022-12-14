package com.loda.mynetTask;

import java.io.IOException;
import java.net.Socket;

public class TcpClient02 {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 60101);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new ClientSendMsg(socket)).start();
        new Thread(new ClientReadMsg(socket)).start();
    }
}
