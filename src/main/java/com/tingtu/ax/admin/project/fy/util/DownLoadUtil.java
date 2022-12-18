package com.tingtu.ax.admin.project.fy.util;

import com.tingtu.ax.admin.project.fy.entity.FyDownFiles;
import com.tingtu.ax.admin.project.fy.service.FyDownFilesService;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
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
    public  void downloadFile2(HttpServletRequest request, HttpServletResponse response,String id)
        throws IOException, URISyntaxException {
        FyDownFiles fyDownFiles = fyDownFilesService.selectByPrimaryKey(Long.valueOf(id));
        String filePath = "D:\\gopath\\"+fyDownFiles.getFilesavename();
        String fileName = "123123.mp3";
        //其他的浏览器
        response.setHeader("Content-Disposition",
            "attachment; filename=\"" + java.net.URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        File file = new File(new URI("http://10.0.0.201/api/v0/cores/self/media/Audio/Test/%E5%A4%A9%E5%A4%96%E6%9D%A5%E7%89%A9-%E8%96%9B%E4%B9%8B%E8%B0%A6.128.mp3"));
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
    public void downloadNet(HttpServletResponse response) throws MalformedURLException {
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

        URL url = new URL("http://10.0.0.201/api/v0/cores/self/media/Audio/Test/%E5%A4%A9%E5%A4%96%E6%9D%A5%E7%89%A9-%E8%96%9B%E4%B9%8B%E8%B0%A6.128.mp3");

        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream("D:\\court\\xxx.mp3");

            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        //测试1
        public static void main(String[] args) {
            System.out.println("test");
            InputStream res = Download2InputStream(" http://10.0.0.201/api/v0/cores/self/media/Audio/Test/%E5%A4%A9%E5%A4%96%E6%9D%A5%E7%89%A9-%E8%96%9B%E4%B9%8B%E8%B0%A6.128.mp3");
            boolean b = WriteFile4InputStream("d:\\court\\123.mp3", res);
            System.out.println(b);
        }


        //传入url链接，获取Text类型的文件（适合文本文件
        public static String Download2String(String url)
        {
            String result = null;
            //okhttp3 获取Http请求
            try {
                result = getResponeBody(url).string();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            //返回获得值
            return  result;
        }

        //通过url获取InputStream
        public static InputStream Download2InputStream(String url)
        {
            InputStream result = null;
            result = getResponeBody(url).byteStream();
            return result;
        }
        //通过url获取ResponseBody，用于转换成String等类型
        public static ResponseBody getResponeBody(String url)
        {
            ResponseBody result =null;
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                .url(url)
                .build();
            Call call = okHttpClient.newCall(request);
            try {
                Response response = call.execute();
//            System.out.println(response.headers());
//            System.out.println(response.body().string());
                result = response.body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
        //将InputStream写入到文件，成功返回true 失败返回false
        public static boolean WriteFile4InputStream(String FilePath,InputStream inputStream)
        {
            //默认为flase 即失败
            boolean result = false;
            try {
                OutputStream os = new FileOutputStream(FilePath);
                os.write(inputStream.readAllBytes());
                os.close();
                result = true;
            }catch (IOException e)
            {
                e.printStackTrace();
                result = false;
            }
            return result;
        }
}
