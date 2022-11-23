package com.tingtu.ax.admin.project.system.permission.model.query;

import com.tingtu.ax.admin.domain.model.query.BaseParams;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 权限查询参数
 *
 * @author Administrator
 * @since 3.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class PermissionParams extends BaseParams {
    /**
     * 菜单id
     */
    private Long menuId;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 标识符
     */
    private String permission;
}
