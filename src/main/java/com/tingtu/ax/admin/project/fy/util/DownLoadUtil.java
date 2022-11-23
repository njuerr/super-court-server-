package com.tingtu.ax.admin.project.fy.util;

import com.tingtu.ax.admin.project.fy.entity.FyDownFiles;
import com.tingtu.ax.admin.project.fy.service.FyDownFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-15 14:20
 **/
@Component
public class DownLoadUtil {

    @Autowired
    private FyDownFilesService fyDownFilesService;

    public  void downloadFile(HttpServletRequest request, HttpServletResponse response,String id)
        throws IOException {
        FyDownFiles fyDownFiles = fyDownFilesService.selectByPrimaryKey(Long.valueOf(id));
        String filePath = "D:\\gopath\\"+fyDownFiles.getFilesavename();
        String fileName = fyDownFiles.getFilename();


        //其他的浏览器
        response.setHeader("Content-Disposition",
            "attachment; filename=\"" + java.net.URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);

        byte[] fileByte = new byte[(int) file.length()];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        byteArrayOutputStream.close();
        fileByte = byteArrayOutputStream.toByteArray();

        OutputStream outputStream = null;
        outputStream = response.getOutputStream();
        outputStream.write(fileByte);
        outputStream.flush();
        outputStream.close();

    }
}
