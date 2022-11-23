package com.tingtu.ax.admin.project.system.role.model.dto;

import com.tingtu.ax.admin.domain.model.InputConverter;
import com.tingtu.ax.admin.project.system.role.model.entity.RoleEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * 角色数据范围
 *
 * @author Administrator
 * @since 3.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class RoleExtDTO extends RoleDTO implements InputConverter<RoleEntity> {
    private List<Long> deptIds;
    private List<Long> permissionIds;
}
