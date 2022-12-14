package com.loda.mynet02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class RecvMsg implements Runnable{
    private Socket socket;

    public RecvMsg() {
    }

    public RecvMsg(Socket socket) {
        this.socket = socket;
    }

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
                 System.out.println(msg);
                 if ("bye".equals(msg)) {
                     try {
                         is.close();
                         br.close();
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
//                is.close();
//                br.close();
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
