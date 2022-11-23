package com.tingtu.ax.admin.project.system.dept.model.query;

import com.tingtu.ax.admin.domain.model.query.BaseParams;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 组织过滤
 *
 * @author Administrator
 * @since 3.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class DeptParams extends BaseParams {
    private String name;
    private Integer isEnabled;
}
