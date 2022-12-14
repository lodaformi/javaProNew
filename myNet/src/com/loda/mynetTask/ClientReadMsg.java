package com.loda.mynetTask;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientReadMsg implements Runnable {
    private Socket socket;

    public ClientReadMsg(Socket socket) {
        this.socket = socket;
    }


    // 读取消息
    @Override
    public void run() {
        InputStream is = null;
        BufferedReader br = null;
        String msg = null;
        try {
            is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while (true) {
                msg = br.readLine();
                if ("bye".equals(msg)) {
                    socket.close();
                    break;
                }
//                System.out.print(Thread.currentThread().getName()+" ReadMsg: ");
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
