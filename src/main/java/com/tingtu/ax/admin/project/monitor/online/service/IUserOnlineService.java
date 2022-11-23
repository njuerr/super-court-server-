package com.tingtu.ax.admin.project.monitor.online.service;

import com.tingtu.ax.admin.project.monitor.online.model.dto.UserOnlineDTO;
import com.tingtu.ax.admin.project.monitor.online.model.query.UserOnlineParams;

import java.util.List;

/**
 * 在线用户
 *
 * @author Administrator
 * @since 3.0.0
 */
public interface IUserOnlineService {
    /**
     * 获取在线用户
     *
     * @return 在线用户
     */
    List<UserOnlineDTO> getOnlineUser(UserOnlineParams vo);

    /**
     * <p>
     * 强退
     * </p>
     *
     * @param token token
     * @return 是否成功
     */
    boolean logout(List<String> token);
}
