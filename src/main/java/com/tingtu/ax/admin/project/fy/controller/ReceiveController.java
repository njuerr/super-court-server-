package com.tingtu.ax.admin.project.fy.controller;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.google.common.collect.Maps;
import com.tingtu.ax.admin.annotation.Log;
import com.tingtu.ax.admin.commons.enums.BusinessTypeEnum;
import com.tingtu.ax.admin.domain.controller.SuperSimpleBaseController;
import com.tingtu.ax.admin.domain.controller.base.IBasePoiController;
import com.tingtu.ax.admin.domain.result.R;
import com.tingtu.ax.admin.domain.result.Result;
import com.tingtu.ax.admin.excel.utils.ExcelConstant;
import com.tingtu.ax.admin.excel.utils.ExcelUtils;
import com.tingtu.ax.admin.exceptions.ExportExceptions;
import com.tingtu.ax.admin.project.fy.dto.LineDTO;
import com.tingtu.ax.admin.project.fy.dto.LineExcelDTO;
import com.tingtu.ax.admin.project.fy.dto.LineParams;
import com.tingtu.ax.admin.project.fy.entity.FyDeviceTimes;
import com.tingtu.ax.admin.project.fy.service.FyDeviceTimesService;
import com.tingtu.ax.admin.project.fy.service.IFyDeviceTimesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-23 10:57
 **/
@RestController
@RequestMapping("/receive")
@Slf4j
public class ReceiveController extends SuperSimpleBaseController<Long, LineDTO, LineParams, FyDeviceTimes> implements IBasePoiController<LineParams> {

    private final IFyDeviceTimesService service;
    @Autowired
    private FyDeviceTimesService deviceTimesService;

    public ReceiveController(IFyDeviceTimesService service) {
        super(service);
        this.service = service;
    }
    @GetMapping("/online")
    public Result<String> courtOnline(Integer courtId){
        log.info("法院:{}上线",courtId);
        deviceTimesService.online(courtId);
        return R.success();
    }

    @GetMapping("/outline")
    public Result<String> courtOutline(Integer courtId){
        log.info("法院:{}下线",courtId);
        deviceTimesService.outline(courtId);
        return R.success();
    }

    @Override
    @PostMapping("/export")
    @Log(value = "导出", paramsName = {"params"}, businessType = BusinessTypeEnum.EXPORT)
    public void export(HttpServletResponse response, LineParams params) throws ExportExceptions {
        List<LineExcelDTO> export = service.export(params);
        HashMap<String, Object> map = Maps.newHashMap();
        try {
            map.put(ExcelConstant.FILE_NAME, "line_excel");
            map.put(ExcelConstant.DATA_LIST, export);
            ExcelUtils.writeWeb(response, map, ExcelTypeEnum.XLS, LineExcelDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExportExceptions("上下线日志导出失败", e);
        }
    }
}
