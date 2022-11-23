package com.tingtu.ax.admin.project.system.role.model.query;

import com.tingtu.ax.admin.domain.model.query.BaseParams;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 角色查询条件
 *
 * @author Administrator
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class RoleParams extends BaseParams {
    private String name;
    private String code;
    private Integer isEnabled;
}
