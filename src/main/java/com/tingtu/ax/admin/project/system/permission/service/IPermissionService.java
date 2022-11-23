package com.tingtu.ax.admin.project.system.permission.service;

import com.tingtu.ax.admin.domain.service.ISuperBaseService;
import com.tingtu.ax.admin.project.system.permission.model.dto.PermissionDTO;
import com.tingtu.ax.admin.project.system.permission.model.entity.PermissionEntity;
import com.tingtu.ax.admin.project.system.permission.model.query.PermissionParams;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;

/**
 * 权限  服务类
 *
 * @author bing_huang
 * @since 3.0.0
 */
public interface IPermissionService extends ISuperBaseService<Long, PermissionParams, PermissionDTO, PermissionEntity> {

    /**
     * 根据id查询启用的权限
     *
     * @param ids id
     * @return 已启用的权限(权限id和权限标识符)
     */
    List<PermissionEntity> findEnabledPermissionByIds(@Nonnull Collection<Long> ids);
}
