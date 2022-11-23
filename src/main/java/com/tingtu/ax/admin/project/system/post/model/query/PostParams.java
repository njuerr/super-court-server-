package com.tingtu.ax.admin.project.system.post.model.query;

import com.tingtu.ax.admin.domain.model.query.BaseParams;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 岗位检索
 *
 * @author Administrator
 * @since 3.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class PostParams extends BaseParams {
    private String name;
    private String number;
    private Integer isEnabled;
}
