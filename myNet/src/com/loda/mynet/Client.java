package com.loda.mynet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket so = new Socket("localhost", 60101);

        OutputStream os = so.getOutputStream();
        InputStream is = so.getInputStream();
        Scanner sc = new Scanner(System.in);
        byte[] by = new byte[128];
        int len = 0;
        String getStr = null;

        while (true) {
            System.out.print("client to server: ");
            String str = sc.next();
            os.write(str.getBytes());

            len = is.read(by);
            getStr = new String(by, 0, len);
            System.out.println(getStr);
//            while ((len = is.read(by)) != -1) {
//                getStr = new String(by, 0, len);
//                if (getStr.equals("break")) {
//                    so.close();
//                    break;
//                }
//                System.out.println(getStr);
//            }
        }
//        so.close();
    }
}
