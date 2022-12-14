package com.loda.mynetTask;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerReadMsg implements Runnable {
    private Socket socket;

    public ServerReadMsg(Socket socket) {
        this.socket = socket;
    }


    //    该线程首先判断是否是“BYE”，若是，则立即向对方发送“BYE”，并结束该线程。
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
                System.out.println(Thread.currentThread().getName()+" : "+ msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
