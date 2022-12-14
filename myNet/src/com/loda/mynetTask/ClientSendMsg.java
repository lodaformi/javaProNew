package com.loda.mynetTask;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;

public class ClientSendMsg implements Runnable {
    private Socket socket;

    public ClientSendMsg(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream is = null;
        BufferedWriter bw = null;
        String msg = null;
        Scanner scanner = new Scanner(System.in);
        try {
            is = socket.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(is));
            while (true) {
//                System.out.print(Thread.currentThread().getName()+": ");
                bw.write(scanner.next() + "\n");
                bw.flush();
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
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
