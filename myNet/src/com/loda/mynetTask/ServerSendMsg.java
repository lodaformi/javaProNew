package com.loda.mynetTask;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerSendMsg implements Runnable {
    private Socket socket;

    public ServerSendMsg(Socket socket) {
        this.socket = socket;
    }


    //    该线程首先判断是否是“BYE”，若是，则立即向对方发送“BYE”，并结束该线程。
    @Override
    public void run() {
        OutputStream os = null;
        BufferedWriter bw = null;
        String msg = null;
        Scanner scanner = new Scanner(System.in);
        try {
            os = socket.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(os));
            while (true) {
//                System.out.print("replay to: ");
                bw.write(scanner.next()+"\n");
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
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
