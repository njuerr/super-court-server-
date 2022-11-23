package com.tingtu.ax.admin.project.monitor.operation.controller;


import com.tingtu.ax.admin.annotation.ClassDescribe;
import com.tingtu.ax.admin.annotation.Log;
import com.tingtu.ax.admin.annotation.PreAuth;
import com.tingtu.ax.admin.commons.enums.BusinessTypeEnum;
import com.tingtu.ax.admin.domain.controller.SuperSimpleBaseController;
import com.tingtu.ax.admin.domain.result.Result;
import com.tingtu.ax.admin.domain.result.R;
import com.tingtu.ax.admin.project.monitor.operation.model.dto.OperLogDTO;
import com.tingtu.ax.admin.project.monitor.operation.model.entity.OperLogEntity;
import com.tingtu.ax.admin.project.monitor.operation.service.query.OperLogParams;
import com.tingtu.ax.admin.project.monitor.operation.service.IOperLogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 操作日志  前端控制器
 *
 * @author Administrator
 * @since 3.0.0
 */
@RestController
@RequestMapping("/monitor/operation/log")
@ClassDescribe("操作日志")
@PreAuth("oper:log")
public class OperLogController extends SuperSimpleBaseController<Long, OperLogDTO, OperLogParams, OperLogEntity> {
    private final IOperLogService service;

    public OperLogController(IOperLogService service) {
        super(service);
        this.service = service;
    }

    /**
     * 清空
     *
     * @return 是否成功
     */
    @GetMapping("/clean")
    @Log(value = "清空", businessType = BusinessTypeEnum.CLEAN)
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','ROLE_MONITOR','oper:log:clean')")
    public Result<String> clean() {
        service.clean();
        return R.success("清除成功");
    }
}

