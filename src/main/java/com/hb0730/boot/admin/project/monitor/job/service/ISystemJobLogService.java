package com.hb0730.boot.admin.project.monitor.job.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hb0730.boot.admin.commons.domain.service.IBaseService;
import com.hb0730.boot.admin.project.monitor.job.model.dto.JobLogExportDTO;
import com.hb0730.boot.admin.project.monitor.job.model.entity.SystemJobLogEntity;
import com.hb0730.boot.admin.project.monitor.job.model.vo.JobLogParams;
import com.hb0730.boot.admin.project.monitor.job.model.vo.SystemJobLogVO;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 定时任务日志  服务类
 * </p>
 *
 * @author bing_huang
 * @since 2020-04-07
 */
public interface ISystemJobLogService extends IService<SystemJobLogEntity>, IBaseService<JobLogParams, SystemJobLogEntity> {

    /**
     * <p>
     * 查询定时任务日志
     * </p>
     *
     * @param params 定时任务过滤条件
     * @return 分页后的日志
     * @since v2.0
     */
    Page<SystemJobLogVO> page(@NotNull JobLogParams params);

    /**
     * <p>
     * 导出
     * </p>
     *
     * @param params 过滤参数
     * @return 导出信息
     */
    List<JobLogExportDTO> export(JobLogParams params);
}
