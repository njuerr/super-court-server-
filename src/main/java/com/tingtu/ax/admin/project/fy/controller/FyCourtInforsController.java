package com.tingtu.ax.admin.project.fy.controller;

import com.tingtu.ax.admin.annotation.Log;
import com.tingtu.ax.admin.commons.enums.BusinessTypeEnum;
import com.tingtu.ax.admin.domain.result.R;
import com.tingtu.ax.admin.domain.result.Result;
import com.tingtu.ax.admin.project.fy.dto.FyFaillogsAddDTO;
import com.tingtu.ax.admin.project.fy.dto.FyFaillogsUpdateDTO;
import com.tingtu.ax.admin.project.fy.dto.ListenOpenDTO;
import com.tingtu.ax.admin.project.fy.entity.FyCourtInfors;
import com.tingtu.ax.admin.project.fy.entity.FyDeviceChannels;
import com.tingtu.ax.admin.project.fy.entity.FyDeviceInfors;
import com.tingtu.ax.admin.project.fy.entity.FyDownFiles;
import com.tingtu.ax.admin.project.fy.qsc.HttpRes;
import com.tingtu.ax.admin.project.fy.qsc.QscUtil;
import com.tingtu.ax.admin.project.fy.service.*;
import com.tingtu.ax.admin.project.fy.util.DownLoadUtil;
import com.tingtu.ax.admin.project.fy.vo.FailLogVo;
import com.tingtu.ax.admin.project.fy.vo.InfoListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-10 16:37
 **/
@RestController
@RequestMapping("/fy/court")
public class FyCourtInforsController {

    @Autowired
    private FyCourtInforsService fyCourtInforsService;
    @Autowired
    private FyDeviceInforsService fyDeviceInforsService;

    @Autowired
    private FyDeviceChannelsService fyDeviceChannelsService;

    @Autowired
    private FyFaillogsService fyFaillogsService;
    @Autowired
    private FyDownFilesService fyDownFilesService;

    @Autowired
    private QscUtil qscUtil;
    @Autowired
    private DownLoadUtil downLoadUtil;


    @GetMapping("/infos")
    @Log(value = "获取法院列表", businessType = BusinessTypeEnum.QUERY)
    public Result<List<InfoListVo>> getInfoList() {
        List<InfoListVo> infoList = fyCourtInforsService.getInfoList();
        return R.success(infoList);
    }

    @GetMapping("/getChannls/{id}")
    @Log(value = "获取通道", businessType = BusinessTypeEnum.QUERY)
    public Result<List<FyDeviceChannels>> getChannls(@PathVariable("id") String id) {
        return R.success(fyDeviceChannelsService.selectByDeviceId(id));
    }

    @GetMapping("/getDeviceUrl/{id}")
    @Log(value = "获取设备Url", businessType = BusinessTypeEnum.QUERY)
    public Result<List<FyDeviceInfors>> getDeviceUrl(@PathVariable("id") String id) {
        return R.success(fyCourtInforsService.getDeviceUrl(id));
    }

    @PostMapping("/getFailLogs/{id}")
    @Log(value = "获取故障日志", businessType = BusinessTypeEnum.QUERY)
    public Result<List<FailLogVo>> getFailLogs(@PathVariable String id) {
        List<FailLogVo> failLogVos = fyFaillogsService.getLogs(id);
        return R.success(failLogVos);
    }

    @PostMapping("/monitorErrorInput")
    @Log(value = "提交故障", businessType = BusinessTypeEnum.INSERT)
    public Result<String> monitorErrorInput(@RequestBody FyFaillogsAddDTO fyFaillogsAddDTO) {
        fyFaillogsService.create(fyFaillogsAddDTO);
        return R.success();
    }

    @PostMapping("/processErrorInput")
    @Log(value = "解决故障", businessType = BusinessTypeEnum.UPDATE)
    public Result<String> processErrorInput(@RequestBody FyFaillogsUpdateDTO fyFaillogsUpdateDTO) {
        fyFaillogsService.process(fyFaillogsUpdateDTO);
        return R.success();
    }

    @PostMapping("/getCourtStatus")
    @Log(value = "查询法院状态", businessType = BusinessTypeEnum.QUERY)
    public Result<List<FyCourtInfors>> getCourtStatus() {
        return R.success(fyCourtInforsService.getCourtStatus());
    }

    @PostMapping("/getFailDevice/{courtId}")
    @Log(value = "查询设备列表", businessType = BusinessTypeEnum.QUERY)
    public Result<List<FyDeviceInfors>> getFailDevice(@PathVariable String courtId) {
        return R.success(fyDeviceInforsService.selectByCourtId(courtId));
    }

    @PostMapping("/listenOpen")
    @Log(value = "打开端口", businessType = BusinessTypeEnum.EXECUTOR)
    public Result<HttpRes> listenOpen(@RequestBody ListenOpenDTO listenOpenDTO) {
        HttpRes httpRes = qscUtil.listenOpen(listenOpenDTO);
        return R.success(httpRes);
    }

    @PostMapping("/failRepair/{courtId}")
    @Log(value = "获取故障列表", businessType = BusinessTypeEnum.QUERY)
    public Result<List<FailLogVo>> failRepair(@PathVariable String courtId) {
        return R.success(fyFaillogsService.failRepair(courtId));
    }

    @PostMapping("/downloadFile/{courtId}")
    @Log(value = "获取文件列表", businessType = BusinessTypeEnum.QUERY)
    public Result<List<FyDownFiles>> downloadFile(@PathVariable String courtId) {
      return R.success(fyDownFilesService.downloadFile(courtId));
    }

    @PostMapping("/devicePosition/{courtId}")
    @Log(value = "设备定位", businessType = BusinessTypeEnum.EXECUTOR)
    public Result<HttpRes> devicePosition(@PathVariable String courtId) {
        return R.success(qscUtil.devicePosition(courtId));
    }

//    @PostMapping("/getMeter/{courtId}")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
//    @Log(value = "删除", businessType = BusinessTypeEnum.DELETE)
//    public Result<MaterRes> getMeter(@PathVariable String courtId) {
//        return R.success(qscUtil.getMeter(courtId));
//    }

//    @PostMapping("/getMeter/{courtId}")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
//    @Log(value = "获取当前法院meter", businessType = BusinessTypeEnum.DELETE)
//    public Result<HttpRes> devicePosition(@PathVariable String courtId) {
//        return R.success(qscUtil.devicePosition(courtId));
//    }

    @GetMapping("/big/indexGetFaultLine")
    public Result<String> indexGetFaultLine() {
        return R.success(qscUtil.IndexGetFaultLine());
    }

    @GetMapping("/big/indexGetOnLineTime")
    public Result<String> indexGetOnLineTime() {
        return R.success(qscUtil.indexGetOnLineTime());
    }

    @GetMapping("/big/getCourtInfo")
    public Result<String> getCourtInfo() {
        return R.success(qscUtil.getCourtInfo());
    }

    @GetMapping("/big/getZoneInfo")
    public Result<String> getZoneInfo() {
        return R.success(qscUtil.getZoneInfo());
    }

    @GetMapping("/download")
    @Log(value = "下载文件", businessType = BusinessTypeEnum.DOWNLOAD)
    public String downLoad(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException {
        downLoadUtil.downloadNet(response);
//        downLoadUtil.downloadFile2(request, response,fileName);
        return "正在下载";
    }


}
