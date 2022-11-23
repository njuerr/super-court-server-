package com.tingtu.ax.admin.project.fy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingtu.ax.admin.domain.service.ISuperBaseService;
import com.tingtu.ax.admin.domain.service.base.ISuperPoiService;
import com.tingtu.ax.admin.project.fy.dto.FailLogDTO;
import com.tingtu.ax.admin.project.fy.dto.FailLogParams;
import com.tingtu.ax.admin.project.fy.dto.FailLogsExcelDTO;
import com.tingtu.ax.admin.project.fy.entity.FyFaillogs;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IFyFaillogsService extends ISuperBaseService<Long, FailLogParams, FailLogDTO, FyFaillogs>, ISuperPoiService<FailLogParams, FailLogsExcelDTO> {
    @Override
    boolean updateById(FailLogDTO dto);

    @Override
    QueryWrapper<FyFaillogs> query(FailLogParams params);

    @Override
    List<FailLogsExcelDTO> export(@NotNull FailLogParams params);
}
