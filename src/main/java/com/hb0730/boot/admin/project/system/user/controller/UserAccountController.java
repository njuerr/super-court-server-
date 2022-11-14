package com.hb0730.boot.admin.project.system.user.controller;


import com.hb0730.boot.admin.domain.controller.SuperSimpleBaseController;
import com.hb0730.boot.admin.project.system.user.model.entity.UserAccountEntity;
import com.hb0730.boot.admin.project.system.user.model.query.UserAccountParams;
import com.hb0730.boot.admin.project.system.user.model.dto.UserAccountDTO;
import com.hb0730.boot.admin.project.system.user.service.IUserAccountService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户账号  前端控制器
 *
 * @author Administrator
 * @since 3.0.0
 */
@RestController
@RequestMapping("/system/user/account")
@Validated
public class UserAccountController extends SuperSimpleBaseController<Long, UserAccountDTO, UserAccountParams, UserAccountEntity> {
    private final IUserAccountService service;

    public UserAccountController(IUserAccountService service) {
        super(service);
        this.service = service;
    }

}

