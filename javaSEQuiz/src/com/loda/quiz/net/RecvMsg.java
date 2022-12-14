package com.loda.quiz.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Author loda
 * @Date 2022/10/19 17:59
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class RecvMsg implements Runnable {
    private static boolean flag = false;
    private Socket socket;

    public RecvMsg(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        String msg = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                msg = br.readLine();
                System.out.println("br1: " + msg);
                if ("bye".equalsIgnoreCase(msg)) {
                    flag = true;
//                    socket.close();
////                    br.close();
                    System.out.println("in if");
                    break;
                }
                System.out.println("br2: " + msg);
            }
            if (flag) {
                socket.close();
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
