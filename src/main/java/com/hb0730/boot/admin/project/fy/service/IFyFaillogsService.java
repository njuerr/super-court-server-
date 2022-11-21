package com.hb0730.boot.admin.project.fy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hb0730.boot.admin.domain.service.ISuperBaseService;
import com.hb0730.boot.admin.domain.service.base.ISuperPoiService;
import com.hb0730.boot.admin.project.fy.dto.FailLogDTO;
import com.hb0730.boot.admin.project.fy.dto.FailLogParams;
import com.hb0730.boot.admin.project.fy.dto.FailLogsExcelDTO;
import com.hb0730.boot.admin.project.fy.entity.FyFaillogs;
import com.hb0730.boot.admin.project.system.post.model.query.PostParams;

import javax.annotation.Nonnull;

public interface IFyFaillogsService extends ISuperBaseService<Long, FailLogParams, FailLogDTO, FyFaillogs>, ISuperPoiService<FailLogParams, FailLogsExcelDTO> {
    @Override
    boolean updateById(FailLogDTO dto);

    @Override
    QueryWrapper<FyFaillogs> query(FailLogParams params);

}
