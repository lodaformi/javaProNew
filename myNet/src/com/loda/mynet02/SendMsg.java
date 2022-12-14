package com.loda.mynet02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendMsg implements Runnable {
    private Socket socket;

    public SendMsg() {
    }

    public SendMsg(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream os = null;
        BufferedWriter bw = null;
        Scanner sc = new Scanner(System.in);
        String msg = null;
        try {
            os = socket.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(os));
            while (true) {
                msg = sc.next();
                bw.write(msg + "\n");
                bw.flush();
                if ("bye".equals(msg)) {
                    try {
                        os.close();
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                os.close();
//                bw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

    }
}
