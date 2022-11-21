package com.hb0730.boot.admin.project.fy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hb0730.boot.admin.commons.utils.DateUtils;
import com.hb0730.boot.admin.commons.utils.QueryWrapperUtils;
import com.hb0730.boot.admin.domain.service.impl.SuperBaseServiceImpl;
import com.hb0730.boot.admin.project.fy.dto.FailLogDTO;
import com.hb0730.boot.admin.project.fy.dto.FailLogParams;
import com.hb0730.boot.admin.project.fy.dto.FailLogsExcelDTO;
import com.hb0730.boot.admin.project.fy.entity.FyFaillogs;
import com.hb0730.boot.admin.project.fy.mapper.FyFaillogsMapper;
import com.hb0730.boot.admin.project.fy.service.IFyFaillogsService;
import com.hb0730.boot.admin.project.system.post.model.dto.PostExcelDTO;
import com.hb0730.boot.admin.project.system.post.model.entity.PostEntity;
import com.hb0730.boot.admin.project.system.post.model.query.PostParams;
import com.hb0730.boot.admin.security.utils.SecurityUtils;
import org.jetbrains.annotations.NotNull;
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
        dto.setProcesstime(DateUtils.format("yyyy-MM-dd HH:mm:ss",new Date()));
        dto.setProcessuser(Objects.requireNonNull(SecurityUtils.getCurrentUser()).getId().toString());
        System.out.println("来了");
        return super.updateById(aLong, dto);
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
