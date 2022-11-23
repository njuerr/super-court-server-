package com.tingtu.ax.admin.project.system.quartz.service;

import com.tingtu.ax.admin.domain.service.ISuperBaseService;
import com.tingtu.ax.admin.project.system.quartz.model.dto.JobLogDTO;
import com.tingtu.ax.admin.project.system.quartz.model.entity.JobLogEntity;
import com.tingtu.ax.admin.project.system.quartz.model.query.JobLogParams;

/**
 * 任务日志  服务类
 *
 * @author Administrator
 * @since 3.0.0
 */
public interface IJobLogService extends ISuperBaseService<Long, JobLogParams, JobLogDTO, JobLogEntity> {

}
