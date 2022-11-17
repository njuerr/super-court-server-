package com.hb0730.boot.admin.project.fy.qsc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.hb0730.boot.admin.project.fy.dto.ListenOpenDTO;
import com.hb0730.boot.admin.project.fy.service.FyDeviceChannelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-11 10:17
 **/
@Component
public class QscUtil {
    @Autowired
    private FyDeviceChannelsService fyDeviceChannelsService;
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

    public MaterRes getMeter(String courtId) {
        String s = null;
        try {
            List<String> mater = fyDeviceChannelsService.getMater(courtId);
            MaterRes materRes = new MaterRes();
            List<String> names= new ArrayList<>();
            List<Double> values= new ArrayList<>();
            s = HttpRequestUtil.sendGet("http://localhost:8090/send", "msg=" + JSON.toJSONString(new MaterRequestVO(mater,courtId)));
            HttpRes httpRes = new Gson().fromJson(s, HttpRes.class);
            System.out.println(httpRes.getMsg());
            MaterResControls materResControls = JSONObject.parseObject(httpRes.getMsg(), MaterResControls.class);
            List<MeterResChanges> changes = materResControls.getParams().getChanges();
            changes.forEach(i->{
                names.add(i.getName());
                values.add(i.getValue());
            });
            materRes.setValues(values);
            materRes.setNames(names);
            return materRes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
//        String s = null;
//        try {
//            s = HttpRequestUtil.sendGet("http://localhost:8090/send", "msg=" + JSON.toJSONString(new MaterRequestVO()));
//            HttpRes httpRes = new Gson().fromJson(s, HttpRes.class);
//                   MaterResControls materResControls = JSONObject.parseObject("", MaterResControls.class);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        MaterResControls materResControls = JSONObject.parseObject("{\"jsonrpc\":\"2.0\",\"method\":\"ChangeGroup.Poll\",\"params\":{\"Id\":\"changegroup_3\",\"Changes\":[{\"Component\":\"web_remoteMonitor_001\",\"Name\":\"meter 12\",\"String\":\"-79.3dB\",\"Value\":-79.3430252,\"Position\":0.0,\"Choices\":[],\"Color\":\"\",\"Indeterminate\":false,\"Invisible\":false,\"Disabled\":false,\"Legend\":\"\"}]}} ", MaterResControls.class);
        materResControls.getParams();


//        try {
//            String s = HttpRequestUtil.sendGet("http:localhost:8090/demo2", "courtId=" + 1);
//            System.out.println(s);
//        } catch (IOException e) {
//            System.out.println(e);
//        }
    }

    public String IndexGetFaultLine() {
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
        try {
            HttpRequestUtil.sendGet("http://localhost:8090/demo5", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
