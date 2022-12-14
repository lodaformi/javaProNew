package com.loda.quiz.net;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author loda
 * @Date 2022/10/19 19:11
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class SendMsg implements Runnable {
    private Socket socket;
    private static boolean flag = false;

    public SendMsg(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedWriter bw = null;
        Scanner sc = new Scanner(System.in);
        String msg = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                msg = sc.next();
                bw.write(msg + "\n");
                bw.flush();
//                if ("bye".equals(msg)) {
//                    flag = true;
//                    break;
//                }
            }
//            if (flag) {
//                bw.close();
//                socket.close();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
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
