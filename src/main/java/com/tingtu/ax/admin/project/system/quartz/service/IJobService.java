package com.tingtu.ax.admin.project.system.quartz.service;

import com.tingtu.ax.admin.domain.service.ISuperBaseService;
import com.tingtu.ax.admin.project.system.quartz.model.dto.JobDTO;
import com.tingtu.ax.admin.project.system.quartz.model.entity.JobEntity;
import com.tingtu.ax.admin.project.system.quartz.model.query.JobParams;

/**
 * 定时任务(quartz)  服务类
 *
 * @author Administrator
 * @since 3.0.0
 */
public interface IJobService extends ISuperBaseService<Long, JobParams, JobDTO, JobEntity> {

    /**
     * 立即执行定时任务
     *
     * @param id 任务id
     */
    void execution(Long id);

    /**
     * 更改状态
     *
     * @param id        id
     * @param isEnabled 状态
     * @return 是否成功
     */
    boolean updateIsPause(Long id, Integer isEnabled);
}
