package com.tingtu.ax.admin.security.controller;

import com.tingtu.ax.admin.domain.result.R;
import com.tingtu.ax.admin.domain.result.Result;
import com.tingtu.ax.admin.security.model.Login;
import com.tingtu.ax.admin.security.service.IUserLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @since 1.0.0
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {
    private final IUserLogin userLogin;

    @PostMapping("/login")
    public Result<Object> login(@Validated @RequestBody Login login) {
        Object result = userLogin.login(login);
        return R.success(result);
    }
}
