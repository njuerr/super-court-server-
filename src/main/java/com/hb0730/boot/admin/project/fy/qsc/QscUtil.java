package com.hb0730.boot.admin.project.fy.qsc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.hb0730.boot.admin.project.fy.dto.ListenOpenDTO;
import lombok.Data;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
}
