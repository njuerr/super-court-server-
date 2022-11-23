package com.tingtu.ax.admin.domain.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 业务单
 *
 * @author Administrator
 * @since 3.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class BusinessDomain extends BaseDomain {
    @TableId(value = "id")
    private Long id;

    public static final String ID = "id";
}
