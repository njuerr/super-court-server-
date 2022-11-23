package com.tingtu.ax.admin.event.role;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 角色权限event 用于动态刷新用户权限
 *
 * @author Administrator
 * @since 3.0.0
 */

public class RolePermissionEvent extends ApplicationEvent {

    @Getter
    private final Long roleId;

    public RolePermissionEvent(Object source, Long roleId) {
        super(source);
        this.roleId = roleId;
    }
}
