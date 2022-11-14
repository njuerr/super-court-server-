package com.hb0730.boot.admin.project.monitor.login.log.service;

import com.hb0730.boot.admin.domain.service.ISuperBaseService;
import com.hb0730.boot.admin.project.monitor.login.log.model.dto.LoginLogDTO;
import com.hb0730.boot.admin.project.monitor.login.log.model.entity.LoginLogEntity;
import com.hb0730.boot.admin.project.monitor.login.log.model.query.LoginLogParams;

/**
 * 登录日志  服务类
 *
 * @author Administrator
 * @since 3.0.0
 */
public interface ILoginLogService extends ISuperBaseService<Long, LoginLogParams, LoginLogDTO, LoginLogEntity> {

    /**
     * 清除
     *
     * @return 是否成功
     */
    boolean clean();
}
