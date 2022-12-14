package com.loda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/11/16 16:50
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class FileController {
    @RequestMapping("uploadFile")
    public String uploadFile(HttpServletRequest request) {
        MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
        MultipartFile mf = mhsr.getFile("file");

        if (mf != null && mf.getSize() >0 ) {
            //得到webapp项目根目录在系统中的真实路径
            String basePath = request.getSession().getServletContext().getRealPath("/");
//            String basePath = request.getServletContext().getRealPath("/");
            System.out.println("basePath: "+ basePath);
            File upload = new File(basePath+"/upload");
            //在根目录下创建upload文件夹
            if (!upload.exists()) {
                upload.mkdir();
            }
            //截取文件名，不包括后缀
            String prefix =mf.getOriginalFilename().substring(0, mf.getOriginalFilename().indexOf("."));
            //截取文件名的后缀，包括点
            String suffix = mf.getOriginalFilename().substring(mf.getOriginalFilename().indexOf("."));
            //拼接上时间戳
            String newfileName = prefix + "_" + System.currentTimeMillis()+suffix;
            try {
                //将文件写入到upload文件夹下
                mf.transferTo(new File(upload, newfileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //设置域对象给前端
            request.setAttribute("msg", "文件上传成功");
        }else {
            request.setAttribute("msg", "文件上传失败");
        }
        //设置返回的视图
        return "result";
    }
}
