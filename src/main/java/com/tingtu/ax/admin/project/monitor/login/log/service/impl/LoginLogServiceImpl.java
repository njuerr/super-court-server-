package com.tingtu.ax.admin.project.monitor.login.log.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tingtu.ax.admin.commons.utils.QueryWrapperUtils;
import com.tingtu.ax.admin.domain.service.impl.SuperBaseServiceImpl;
import com.tingtu.ax.admin.project.monitor.login.log.mapper.ILoginLogMapper;
import com.tingtu.ax.admin.project.monitor.login.log.model.dto.LoginLogDTO;
import com.tingtu.ax.admin.project.monitor.login.log.model.entity.LoginLogEntity;
import com.tingtu.ax.admin.project.monitor.login.log.model.query.LoginLogParams;
import com.tingtu.ax.admin.project.monitor.login.log.service.ILoginLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * 登录日志  服务实现类
 *
 * @author Administrator
 * @since 3.0.0
 */
@Service
public class LoginLogServiceImpl extends SuperBaseServiceImpl<Long, LoginLogParams, LoginLogDTO, LoginLogEntity, ILoginLogMapper> implements ILoginLogService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean clean() {
        return super.remove(Wrappers.lambdaQuery());
    }

    @Override
    public QueryWrapper<LoginLogEntity> query(@Nonnull LoginLogParams params) {

        QueryWrapper<LoginLogEntity> queryWrapper = QueryWrapperUtils.getQuery(params);
        if (StrUtil.isNotBlank(params.getUsername())) {
            queryWrapper.eq(LoginLogEntity.USERNAME, params.getUsername());
        }
        if (StrUtil.isNotBlank(params.getLoginIp())) {
            queryWrapper.eq(LoginLogEntity.LOGIN_IP, params.getLoginIp());
        }
        if (Objects.nonNull(params.getStatus())) {
            queryWrapper.eq(LoginLogEntity.STATUS, params.getStatus());
        }
        if (Objects.nonNull(params.getStartTime())) {
            queryWrapper.gt(LoginLogEntity.CREATE_TIME, params.getStartTime());
        }
        if (Objects.nonNull(params.getEndTime())) {
            queryWrapper.le(LoginLogEntity.CREATE_TIME, params.getEndTime());
        }
        return queryWrapper;
    }
}
