package com.tingtu.ax.admin.security.service;

import com.tingtu.ax.admin.security.model.Login;

/**
 * @author Administrator
 * @since 1.0.0
 */
public interface IUserLogin {
    /**
     * 登录
     * @param login 登录信息
     * @return 响应信息
     */
    Object login(Login login);
}
