package com.loda.file;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author loda
 * @Date 2022/10/29 15:17
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */

@WebServlet("/downfile")
public class Downfile extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String path = getServletContext().getRealPath("/");

        String name = req.getParameter("fileName");

        File file = new File(path + name);

        if (file.exists() && file.isFile()) {
            resp.setContentType("application/x-msdownload");

            resp.setHeader("Content-Disposition", "attachment; filename=" + name);

            InputStream is = new FileInputStream(file);

            ServletOutputStream os = resp.getOutputStream();

            byte[] bytes = new byte[1024];

            int len = 0;

            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }

            os.close();
            is.close();
        } else {
            System.out.println("file doesn't exist, down failed!");
        }

    }
}
