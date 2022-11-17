package com.hb0730.boot.admin.project.fy.qsc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.hb0730.boot.admin.project.fy.dto.ListenOpenDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-11 10:17
 **/
@Component
public class QscUtil {

    public HttpRes listenOpen(ListenOpenDTO listenOpenDTO) {
        try {
            String s = HttpRequestUtil.sendPost("http:localhost:8090/remoteListen", new Gson().toJson(listenOpenDTO));
            return new Gson().fromJson(s, HttpRes.class);
        } catch (Exception e) {
            return new HttpRes();
        }
    }

    public HttpRes devicePosition(String courtId) {
        try {
            String s = HttpRequestUtil.sendGet("http:localhost:8090/demo2", "courtId=" + courtId);
            return new Gson().fromJson(s, HttpRes.class);
        } catch (IOException e) {
            return new HttpRes();
        }
    }


    public static void main(String[] args) {
        String s = null;
        try {
            s = HttpRequestUtil.sendGet("http://localhost:8090/send", "msg="+JSON.toJSONString(new MaterRequestVO()));
            HttpRes httpRes = new Gson().fromJson(s, HttpRes.class);
            System.out.println(httpRes.getMsg());
//            MaterResControls materResControls = new Gson().fromJson(httpRes.getMsg(), MaterResControls.class);
//            System.out.println(materResControls.getParams().getChanges().get(1).getName());
            MaterResControls materResControls = JSONObject.parseObject(httpRes.getMsg(), MaterResControls.class);
            System.out.println(materResControls.getParams().getChanges().get(1).getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        try {
//            String s = HttpRequestUtil.sendGet("http:localhost:8090/demo2", "courtId=" + 1);
//            System.out.println(s);
//        } catch (IOException e) {
//            System.out.println(e);
//        }
    }

    public String IndexGetFaultLine(){
        String s = null;
        try {
            s = HttpRequestUtil.sendGet("http://localhost:8090/IndexGetFaultLine", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       return s;
    }

    public String indexGetOnLineTime() {
        String s = null;
        try {
            s = HttpRequestUtil.sendGet("http://localhost:8090/IndexGetOnLineTime", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    public String getCourtInfo() {
        String s = null;
        try {
            s = HttpRequestUtil.sendGet("http://localhost:8090/GetCourtInfo", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    public String getZoneInfo() {
        String s = null;
        try {
            s = HttpRequestUtil.sendGet("http://localhost:8090/GetZoneInfo", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    public static void getGlobalData() throws IOException {
//        try {
//           HttpRequestUtil.sendGet("http://localhost:8090/demo5", "");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        Socket sc = new Socket("10.0.0.201", 1710);
        // 为了发送数据，应该获取socket中的输出流
        OutputStream out = sc.getOutputStream();
        String s = "{\n" +
            "    \"jsonrpc\": \"2.0\",\n" +
            "    \"id\": 1234,\n" +
            "    \"method\": \"Component.Set\",\n" +
            "    \"params\": {\n" +
            "        \"Name\": \"web_remoteMonitor_001\",\n" +
            "        \"Controls\": [\n" +
            "            {\n" +
            "                \"Name\": \"coreIdentify\",\n" +
            "                \"Value\": 1\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}\\x00";
        // write接收字节数据
        out.write(s.getBytes());

        InputStream is = sc.getInputStream();

        byte[] by = new byte[1024];
        int len = is.read(by);//read没读到数据会监听等待
        System.out.println(new String(by, 0 ,len));
        sc.close();
    }

}
