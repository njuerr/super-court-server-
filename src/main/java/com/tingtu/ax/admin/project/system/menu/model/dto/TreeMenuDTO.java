package com.tingtu.ax.admin.project.system.menu.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * 树形菜单
 *
 * @author Administrator
 * @since 3.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class TreeMenuDTO extends MenuDTO {
    /**
     * 子树
     */
    private List<TreeMenuDTO> children;
}
