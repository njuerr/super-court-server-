package com.hb0730.boot.admin.project.fy.entity;

import lombok.Data;

@Data
public class FyNavigateMenus {
    private Long id;

    private String menuName;

    private String menuLink;

    private Long menuPrivileges;

    private Long menuSort;
}
