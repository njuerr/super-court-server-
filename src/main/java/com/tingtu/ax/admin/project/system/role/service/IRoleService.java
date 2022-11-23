package com.tingtu.ax.admin.project.system.role.service;

import com.tingtu.ax.admin.domain.service.ISuperBaseService;
import com.tingtu.ax.admin.project.system.role.model.dto.RoleExtDTO;
import com.tingtu.ax.admin.project.system.role.model.entity.RoleEntity;
import com.tingtu.ax.admin.project.system.role.model.query.RoleParams;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;

/**
 * 角色  服务类
 *
 * @author Administrator
 * @since 3.0.0
 */
public interface IRoleService extends ISuperBaseService<Long, RoleParams, RoleExtDTO, RoleEntity> {
    /**
     * 根据角色修改分配的权限
     *
     * @param id            角色id
     * @param permissionIds 权限id
     * @return 是否成功
     */
    boolean updateRolePermission(@Nonnull Long id, List<Long> permissionIds);

    /**
     * 根据id查询已启用的角色
     *
     * @param ids 角色id
     * @return 角色(角色id和角色标识符)
     */
    List<RoleEntity> findEnabledRoleByIds(@Nonnull Collection<Long> ids);
}
