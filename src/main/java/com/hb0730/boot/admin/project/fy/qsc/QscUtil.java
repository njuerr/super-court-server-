package com.hb0730.boot.admin.project.fy.qsc;

import com.google.gson.Gson;
import com.hb0730.boot.admin.project.fy.dto.ListenOpenDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;

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
            s = HttpRequestUtil.sendGet("http://localhost:8090/IndexGetFaultLine", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(s);
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

    public static void getGlobalData() {
        try {
           HttpRequestUtil.sendGet("http://localhost:8090/demo5", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
