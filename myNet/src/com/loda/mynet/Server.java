package com.loda.mynet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(60101);

        Socket so = ss.accept();
        Scanner sc = new Scanner(System.in);
        OutputStream os = so.getOutputStream();
        InputStream is = so.getInputStream();
        byte[] by = new byte[128];
        String getStr = "null";
        int len = 0;

        outer:while (true) {
            len = is.read(by);
            getStr = new String(by, 0, len);
            System.out.println(getStr);

//            while ((len = is.read(by)) != -1) {
//                getStr = new String(by, 0, len);
//                if (getStr.equals("break")) {
//                    ss.close();
//                    break outer;
//                }
//                System.out.println(getStr);
////                continue;
//            }

            System.out.print("server to client: ");
            String str = sc.next();
            os.write(str.getBytes());
        }
//        ss.close();
    }
}
