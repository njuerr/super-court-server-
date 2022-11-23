package com.tingtu.ax.admin.project.monitor.login.log.controller;


import com.tingtu.ax.admin.annotation.ClassDescribe;
import com.tingtu.ax.admin.annotation.Log;
import com.tingtu.ax.admin.annotation.PreAuth;
import com.tingtu.ax.admin.commons.enums.BusinessTypeEnum;
import com.tingtu.ax.admin.domain.controller.SuperSimpleBaseController;
import com.tingtu.ax.admin.domain.result.Result;
import com.tingtu.ax.admin.domain.result.R;
import com.tingtu.ax.admin.project.monitor.login.log.model.dto.LoginLogDTO;
import com.tingtu.ax.admin.project.monitor.login.log.model.entity.LoginLogEntity;
import com.tingtu.ax.admin.project.monitor.login.log.model.query.LoginLogParams;
import com.tingtu.ax.admin.project.monitor.login.log.service.ILoginLogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录日志  前端控制器
 *
 * @author Administrator
 * @since 3.0.0
 */
@RestController
@RequestMapping("/monitor/log/login")
@PreAuth("login:log")
@ClassDescribe("登录日志")
public class LoginLogController extends SuperSimpleBaseController<Long, LoginLogDTO, LoginLogParams, LoginLogEntity> {

    private final ILoginLogService service;

    public LoginLogController(ILoginLogService service) {
        super(service);
        this.service = service;
    }

    /**
     * 清除
     *
     * @return 是否成功
     */
    @GetMapping("/clean")
    @Log(value = "清除", businessType = BusinessTypeEnum.CLEAN)
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR','login:log:clean')")
    public Result<String> clean() {
        service.clean();
        return R.success("清除成功");
    }


}

