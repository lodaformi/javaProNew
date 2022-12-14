package com.loda.quiz.net;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author loda
 * @Date 2022/10/19 17:43
 * @Description 服务端处理消息线程类
 * @Version 1.0
 */
public class TackleMsg implements Runnable {
    private static boolean flag = false;
    private Socket socket;

    public TackleMsg(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        String msg = null;
        Scanner sc = new Scanner(System.in);

        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true) {
                msg = br.readLine();
                System.out.println(msg);
                if ("bye".equalsIgnoreCase(msg)) {
                    bw.write("bye" + "\n");
                    bw.flush();
                    flag = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
