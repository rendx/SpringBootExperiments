package com.huawei.springbootdemo.controller;

import com.huawei.springbootdemo.domain.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@PropertySource("classpath:application.properties")
public class FileController {
//    private static final String filePath = "D:\\IdeaProjects\\springbootdemo\\src\\main\\resources\\static\\images\\";
    @Value("${web.file.path}")
    private String filePath;
    @RequestMapping(path = "upload")
    @ResponseBody
    public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {

        System.out.println("配置注入：文件路径：" + filePath);

        String name = request.getParameter("name");
        System.out.println("用户名：" + name);

        String fileName = file.getOriginalFilename();
        System.out.println("文件名：" + fileName);

        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("文件后缀名：" + suffixName);

        String fileNameUploaded = UUID.randomUUID() + suffixName;

        File destFile = new File(filePath + fileNameUploaded);

        try {
            file.transferTo(destFile);
            return new JsonData(0, fileNameUploaded);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonData(-1, null, "Failed to save");
    }
}
