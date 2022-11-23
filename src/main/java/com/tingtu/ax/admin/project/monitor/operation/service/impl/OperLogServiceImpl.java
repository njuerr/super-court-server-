package com.tingtu.ax.admin.project.monitor.operation.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tingtu.ax.admin.commons.utils.QueryWrapperUtils;
import com.tingtu.ax.admin.domain.service.impl.SuperBaseServiceImpl;
import com.tingtu.ax.admin.project.monitor.operation.mapper.IOperLogMapper;
import com.tingtu.ax.admin.project.monitor.operation.model.dto.OperLogDTO;
import com.tingtu.ax.admin.project.monitor.operation.model.entity.OperLogEntity;
import com.tingtu.ax.admin.project.monitor.operation.service.query.OperLogParams;
import com.tingtu.ax.admin.project.monitor.operation.service.IOperLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * 操作日志  服务实现类
 *
 * @author Administrator
 * @since 3.0.0
 */
@Service
public class OperLogServiceImpl extends SuperBaseServiceImpl<Long, OperLogParams, OperLogDTO, OperLogEntity, IOperLogMapper> implements IOperLogService {

    @Override
    public QueryWrapper<OperLogEntity> query(@Nonnull OperLogParams params) {
        QueryWrapper<OperLogEntity> queryWrapper = QueryWrapperUtils.getQuery(params);
        if (StrUtil.isNotBlank(params.getUsername())) {
            queryWrapper.eq(OperLogEntity.USERNAME, params.getUsername());
        }
        if (StrUtil.isNotBlank(params.getDescription())) {
            queryWrapper.like(OperLogEntity.DESCRIPTION, params.getDescription());
        }
        if (Objects.nonNull(params.getOperType())) {
            queryWrapper.eq(OperLogEntity.OPER_TYPE, params.getOperType());
        }
        if (Objects.nonNull(params.getStatus())) {
            queryWrapper.eq(OperLogEntity.STATUS, params.getStatus());
        }
        if (Objects.nonNull(params.getStartTime())) {
            queryWrapper.gt(OperLogEntity.CREATE_TIME, params.getStartTime());
        }
        if (Objects.nonNull(params.getEndTime())) {
            queryWrapper.le(OperLogEntity.CREATE_TIME, params.getEndTime());
        }
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean clean() {
        return super.remove(Wrappers.lambdaQuery());
    }
}
