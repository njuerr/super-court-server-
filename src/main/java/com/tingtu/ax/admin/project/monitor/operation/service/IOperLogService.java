package com.tingtu.ax.admin.project.monitor.operation.service;

import com.tingtu.ax.admin.domain.service.ISuperBaseService;
import com.tingtu.ax.admin.project.monitor.operation.model.dto.OperLogDTO;
import com.tingtu.ax.admin.project.monitor.operation.model.entity.OperLogEntity;
import com.tingtu.ax.admin.project.monitor.operation.service.query.OperLogParams;

/**
 * 操作日志  服务类
 *
 * @author Administrator
 * @since 3.0.0
 */
public interface IOperLogService extends ISuperBaseService<Long, OperLogParams, OperLogDTO, OperLogEntity> {

    /**
     * 清空
     *
     * @return 是否成功
     */
    boolean clean();
}
