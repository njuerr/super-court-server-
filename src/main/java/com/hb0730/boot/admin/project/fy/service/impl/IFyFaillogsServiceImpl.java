package com.hb0730.boot.admin.project.fy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hb0730.boot.admin.commons.utils.DateUtils;
import com.hb0730.boot.admin.commons.utils.QueryWrapperUtils;
import com.hb0730.boot.admin.domain.service.impl.SuperBaseServiceImpl;
import com.hb0730.boot.admin.project.fy.dto.FailLogDTO;
import com.hb0730.boot.admin.project.fy.dto.FailLogParams;
import com.hb0730.boot.admin.project.fy.dto.FailLogsExcelDTO;
import com.hb0730.boot.admin.project.fy.entity.FyFaillogs;
import com.hb0730.boot.admin.project.fy.mapper.FyFaillogsMapper;
import com.hb0730.boot.admin.project.fy.service.FyCourtInforsService;
import com.hb0730.boot.admin.project.fy.service.IFyFaillogsService;
import com.hb0730.boot.admin.project.system.post.model.dto.PostExcelDTO;
import com.hb0730.boot.admin.project.system.post.model.entity.PostEntity;
import com.hb0730.boot.admin.project.system.post.model.query.PostParams;
import com.hb0730.boot.admin.project.system.user.service.IUserInfoService;
import com.hb0730.boot.admin.security.utils.SecurityUtils;
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
        return BeanUtil.copyToList(entities, FailLogsExcelDTO.class);
    }

    @Override
    public boolean upload(Collection<FailLogsExcelDTO> dataList) {
        return false;
    }

    @Override
    public boolean updateById(Long aLong, FailLogDTO dto) {
        dto.setProcesstime(DateUtils.format("yyyy-MM-dd HH:mm:ss", new Date()));
        dto.setProcessuser(Objects.requireNonNull(SecurityUtils.getCurrentUser()).getId().toString());
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
