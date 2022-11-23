package com.hb0730.boot.admin.project.fy.controller;

import com.hb0730.boot.admin.domain.result.R;
import com.hb0730.boot.admin.domain.result.Result;
import com.hb0730.boot.admin.project.fy.service.FyDeviceTimesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-23 10:57
 **/
@RestController
@RequestMapping("/receive")
@Slf4j
public class ReceiveController {

    @Autowired
    private FyDeviceTimesService fyDeviceTimesService;
    @GetMapping("/online")
    public Result<String> courtOnline(Integer courtId){
        log.info("法院:{}上线",courtId);
        fyDeviceTimesService.online(courtId);
        return R.success();
    }

    @GetMapping("/outline")
    public Result<String> courtOutline(Integer courtId){
        log.info("法院:{}下线",courtId);
        fyDeviceTimesService.outline(courtId);
        return R.success();
    }
}
