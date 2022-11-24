package com.tingtu.ax.admin.project.fy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tingtu.ax.admin.commons.utils.DateUtils;
import com.tingtu.ax.admin.commons.utils.QueryWrapperUtils;
import com.tingtu.ax.admin.domain.service.impl.SuperBaseServiceImpl;
import com.tingtu.ax.admin.project.fy.dto.FailLogDTO;
import com.tingtu.ax.admin.project.fy.dto.FailLogParams;
import com.tingtu.ax.admin.project.fy.dto.FailLogsExcelDTO;
import com.tingtu.ax.admin.project.fy.entity.FyFaillogs;
import com.tingtu.ax.admin.project.fy.mapper.FyFaillogsMapper;
import com.tingtu.ax.admin.project.fy.service.FyCourtInforsService;
import com.tingtu.ax.admin.project.fy.service.IFyFaillogsService;
import com.tingtu.ax.admin.project.system.user.service.IUserInfoService;
import com.tingtu.ax.admin.security.utils.SecurityUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.*;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-21 14:43
 **/
@Service
public class IFyFaillogsServiceImpl extends SuperBaseServiceImpl<Long, FailLogParams, FailLogDTO, FyFaillogs, FyFaillogsMapper> implements IFyFaillogsService {

    @Autowired
    private FyCourtInforsService fyCourtInforsService;

    @Autowired
    private IUserInfoService userInfoService;

    @Override
    public List<FailLogsExcelDTO> export(@NotNull FailLogParams params) {
        QueryWrapper<FyFaillogs> query = this.query(params);
        List<FyFaillogs> entities = super.list(query);
        List<FailLogsExcelDTO> failLogsExcelDTOS = BeanUtil.copyToList(entities, FailLogsExcelDTO.class);
        for (FailLogsExcelDTO failLogsExcelDTO : failLogsExcelDTOS) {
            failLogsExcelDTO.setCourtName(
                fyCourtInforsService.selectByPrimaryKey(Long.valueOf(failLogsExcelDTO.getCourtid())).getCourtName());
            failLogsExcelDTO.setReportuserName(userInfoService.getById(failLogsExcelDTO.getReportuser()).getNickName());
            if (failLogsExcelDTO.getProcessuser() != null) {
                failLogsExcelDTO.setProcessuserName(userInfoService.getById(failLogsExcelDTO.getProcessuser()).getNickName());
            }
        }
        return failLogsExcelDTOS;
    }

    @Override
    public boolean upload(Collection<FailLogsExcelDTO> dataList) {
        return false;
    }

    @Override
    public boolean updateById(Long aLong, FailLogDTO dto) {
        dto.setProcesstime(DateUtils.format("yyyy-MM-dd HH:mm:ss", new Date()));
        dto.setProcessuser(Objects.requireNonNull(SecurityUtils.getCurrentUser()).getId().toString());
        dto.setRepair("1");
        return super.updateById(aLong, dto);
    }

    @Override
    public Page<FailLogDTO> page(FailLogParams params) {
        Page<FailLogDTO> page = super.page(params);
        for (FailLogDTO record : page.getRecords()) {
            record.setCourtName(
                fyCourtInforsService.selectByPrimaryKey(Long.valueOf(record.getCourtid())).getCourtName());
            record.setReportuserName(userInfoService.getById(record.getReportuser()).getNickName());
            if (record.getProcessuser() != null) {
                record.setProcessuserName(userInfoService.getById(record.getProcessuser()).getNickName());
            }
        }
        return page;
    }

    @Override
    @Nonnull
    public QueryWrapper<FyFaillogs> query(@Nonnull FailLogParams params) {
        QueryWrapper<FyFaillogs> query = QueryWrapperUtils.getQuery(params);
        if (StrUtil.isNotBlank(params.getFailid())) {
            query.eq(FyFaillogs.FAILID, params.getFailid());
        }
        return query;
    }

}
