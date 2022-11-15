package com.hb0730.boot.admin.project.fy.controller;

import com.hb0730.boot.admin.annotation.Log;
import com.hb0730.boot.admin.commons.enums.BusinessTypeEnum;
import com.hb0730.boot.admin.domain.result.R;
import com.hb0730.boot.admin.domain.result.Result;
import com.hb0730.boot.admin.project.fy.dto.FyFaillogsAddDTO;
import com.hb0730.boot.admin.project.fy.dto.FyFaillogsUpdateDTO;
import com.hb0730.boot.admin.project.fy.dto.ListenOpenDTO;
import com.hb0730.boot.admin.project.fy.entity.FyCourtInfors;
import com.hb0730.boot.admin.project.fy.entity.FyDeviceChannels;
import com.hb0730.boot.admin.project.fy.entity.FyDeviceInfors;
import com.hb0730.boot.admin.project.fy.qsc.HttpRes;
import com.hb0730.boot.admin.project.fy.qsc.QscUtil;
import com.hb0730.boot.admin.project.fy.service.*;
import com.hb0730.boot.admin.project.fy.vo.FailLogVo;
import com.hb0730.boot.admin.project.fy.vo.InfoListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/infos")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
    @Log(value = "获取法院列表", businessType = BusinessTypeEnum.DELETE)
    public Result<List<InfoListVo>> getInfoList() {
        List<InfoListVo> infoList = fyCourtInforsService.getInfoList();
        return R.success(infoList);
    }

    @GetMapping("/getChannls/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
    @Log(value = "获取通道", businessType = BusinessTypeEnum.DELETE)
    public Result<List<FyDeviceChannels>> getChannls(@PathVariable("id") String id) {
        return R.success(fyDeviceChannelsService.selectByDeviceId(id));
    }

    @GetMapping("/getDeviceUrl/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
    @Log(value = "获取设备Url", businessType = BusinessTypeEnum.DELETE)
    public Result<List<FyDeviceInfors>> getDeviceUrl(@PathVariable("id") String id) {
        return R.success(fyCourtInforsService.getDeviceUrl(id));
    }

    @PostMapping("/getFailLogs/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
    @Log(value = "获取故障日志", businessType = BusinessTypeEnum.DELETE)
    public Result<List<FailLogVo>> getFailLogs(@PathVariable String id) {
        List<FailLogVo> failLogVos = fyFaillogsService.getLogs(id);
        return R.success(failLogVos);
    }

    @PostMapping("/monitorErrorInput")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
    @Log(value = "删除", businessType = BusinessTypeEnum.DELETE)
    public Result<String> monitorErrorInput(@RequestBody FyFaillogsAddDTO fyFaillogsAddDTO) {
        fyFaillogsService.create(fyFaillogsAddDTO);
        return R.success();
    }

    @PostMapping("/processErrorInput")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
    @Log(value = "删除", businessType = BusinessTypeEnum.DELETE)
    public Result<String> processErrorInput(@RequestBody FyFaillogsUpdateDTO fyFaillogsUpdateDTO) {
        fyFaillogsService.process(fyFaillogsUpdateDTO);
        return R.success();
    }

    @PostMapping("/getCourtStatus")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
    @Log(value = "删除", businessType = BusinessTypeEnum.DELETE)
    public Result<List<FyCourtInfors>> getCourtStatus() {
        return R.success(fyCourtInforsService.getCourtStatus());
    }

    @PostMapping("/getFailDevice/{courtId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
    @Log(value = "删除", businessType = BusinessTypeEnum.DELETE)
    public Result<List<FyDeviceInfors>> getFailDevice(@PathVariable String courtId) {
        return R.success(fyDeviceInforsService.selectByCourtId(courtId));
    }

    @PostMapping("/listenOpen")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
    @Log(value = "删除", businessType = BusinessTypeEnum.DELETE)
    public Result<HttpRes> listenOpen(@RequestBody ListenOpenDTO listenOpenDTO) {
        HttpRes httpRes = qscUtil.listenOpen(listenOpenDTO);
        return R.success(httpRes);
    }

    @PostMapping("/failRepair/{courtId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
    @Log(value = "删除", businessType = BusinessTypeEnum.DELETE)
    public Result<List<FailLogVo>> failRepair(@PathVariable String courtId) {
        return R.success(fyFaillogsService.failRepair(courtId));
    }

    @PostMapping("/downloadFile/{courtId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
    @Log(value = "删除", businessType = BusinessTypeEnum.DELETE)
    public void downloadFile(@PathVariable String courtId) {
        fyDownFilesService.downloadFile(courtId);
    }

    @PostMapping("/devicePosition/{courtId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
    @Log(value = "删除", businessType = BusinessTypeEnum.DELETE)
    public Result<HttpRes> devicePosition(@PathVariable String courtId) {
        return R.success(qscUtil.devicePosition(courtId));
    }

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
}
