package com.hb0730.boot.admin.project.fy.entity;

import lombok.Data;

@Data
public class FyUsers {
    private Long id;

    private Long userId;

    private String userName;

    private String userPasswd;

    private Long privileges;

    private String courtId;

    private String zoneId;
}
