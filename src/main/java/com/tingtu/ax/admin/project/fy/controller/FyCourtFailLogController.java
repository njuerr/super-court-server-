package com.tingtu.ax.admin.project.fy.controller;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.google.common.collect.Maps;
import com.tingtu.ax.admin.annotation.Log;
import com.tingtu.ax.admin.commons.enums.BusinessTypeEnum;
import com.tingtu.ax.admin.domain.controller.SuperSimpleBaseController;
import com.tingtu.ax.admin.domain.controller.base.IBasePoiController;
import com.tingtu.ax.admin.excel.utils.ExcelConstant;
import com.tingtu.ax.admin.excel.utils.ExcelUtils;
import com.tingtu.ax.admin.exceptions.ExportExceptions;
import com.tingtu.ax.admin.project.fy.dto.FailLogDTO;
import com.tingtu.ax.admin.project.fy.dto.FailLogParams;
import com.tingtu.ax.admin.project.fy.dto.FailLogsExcelDTO;
import com.tingtu.ax.admin.project.fy.entity.FyFaillogs;
import com.tingtu.ax.admin.project.fy.service.IFyFaillogsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-21 13:56
 **/
@RestController
@RequestMapping("/fy/court")
public class FyCourtFailLogController extends SuperSimpleBaseController<Long, FailLogDTO, FailLogParams, FyFaillogs> implements IBasePoiController<FailLogParams> {

    private final IFyFaillogsService service;

    public FyCourtFailLogController(IFyFaillogsService service) {
        super(service);
        this.service = service;
    }

    @Override
    @PostMapping("/export")
    @Log(value = "导出", paramsName = {"params"}, businessType = BusinessTypeEnum.EXPORT)
    public void export(HttpServletResponse response, @RequestBody FailLogParams params) throws ExportExceptions {
        List<FailLogsExcelDTO> export = service.export(params);
        HashMap<String, Object> map = Maps.newHashMap();
        try {
            map.put(ExcelConstant.FILE_NAME, "fail_log_excel");
            map.put(ExcelConstant.DATA_LIST, export);
            ExcelUtils.writeWeb(response, map, ExcelTypeEnum.XLS, FailLogsExcelDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExportExceptions("故障日志导出失败", e);
        }
    }
}
