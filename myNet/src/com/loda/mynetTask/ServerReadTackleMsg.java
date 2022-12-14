package com.loda.mynetTask;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerReadTackleMsg implements Runnable {
    private Socket socket;

    public ServerReadTackleMsg(Socket socket) {
        this.socket = socket;
    }
    //    该线程首先判断是否是“BYE”，若是，则立即向对方发送“BYE”，并结束该线程。
    @Override
    public void run() {
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        String msg = null;
        Scanner scanner = new Scanner(System.in);
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            br = new BufferedReader(new InputStreamReader(is));
            bw = new BufferedWriter(new OutputStreamWriter(os));
//            Thread th = null;
//            CloseSockerThread closeSockerThread = new CloseSockerThread(socket);
            while (true) {
//                th = new Thread(closeSockerThread);
                msg = br.readLine();
                if ("bye".equals(msg)) {
                    bw.write("bye"+"\n");
                    bw.flush();
                    socket.close();
                    break;
                }
                System.out.println(msg);
//                System.out.println(Thread.currentThread().getName()+" : "+ msg);
//                System.out.print("replay to: ");
//                bw.write(scanner.next()+"\n");
//                bw.flush();
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
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
