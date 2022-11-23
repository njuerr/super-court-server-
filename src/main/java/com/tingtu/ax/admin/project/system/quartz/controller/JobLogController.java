package com.tingtu.ax.admin.project.system.quartz.controller;


import com.tingtu.ax.admin.annotation.ClassDescribe;
import com.tingtu.ax.admin.annotation.PreAuth;
import com.tingtu.ax.admin.domain.controller.SuperSimpleBaseController;
import com.tingtu.ax.admin.project.system.quartz.model.dto.JobLogDTO;
import com.tingtu.ax.admin.project.system.quartz.model.entity.JobLogEntity;
import com.tingtu.ax.admin.project.system.quartz.model.query.JobLogParams;
import com.tingtu.ax.admin.project.system.quartz.service.IJobLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 任务日志  前端控制器
 *
 * @author Administrator
 * @since 3.0.0
 */
@RestController
@RequestMapping("/system/job/log")
@ClassDescribe("任务日志")
@PreAuth("job:log")
public class JobLogController extends SuperSimpleBaseController<Long, JobLogDTO, JobLogParams, JobLogEntity> {
    private final IJobLogService service;

    public JobLogController(IJobLogService service) {
        super(service);
        this.service = service;
    }
}

