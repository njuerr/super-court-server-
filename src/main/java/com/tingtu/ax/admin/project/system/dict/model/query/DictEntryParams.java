package com.tingtu.ax.admin.project.system.dict.model.query;

import com.tingtu.ax.admin.domain.model.query.BaseParams;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 数据字典项过滤
 *
 * @author Administrator
 * @since 3.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class DictEntryParams extends BaseParams {
    private Long parentId;
}
