package com.tingtu.ax.admin.project.system.user.service;

import com.tingtu.ax.admin.domain.service.ISuperBaseService;
import com.tingtu.ax.admin.project.system.user.model.dto.UserDTO;
import com.tingtu.ax.admin.project.system.user.model.dto.UserInfoDTO;
import com.tingtu.ax.admin.project.system.user.model.entity.UserInfoEntity;
import com.tingtu.ax.admin.project.system.user.model.query.UserInfoParams;

/**
 * 用户信息  服务类
 *
 * @author Administrator
 * @since 3.0.0
 */
public interface IUserInfoService extends ISuperBaseService<Long, UserInfoParams, UserInfoDTO, UserInfoEntity> {


    /**
     * 根据账号获取用户关联信息
     *
     * @param username 用户账号
     * @return 用户关联信息
     */
    UserDTO loadUserByUsername(String username);

    /**
     * 重置密码
     *
     * @param id 用户id
     * @return 是否成功
     */
    boolean restPassword(Long id);

}
