package com.hb0730.boot.admin.project.fy.entity;

import lombok.Data;

@Data
public class FySystemlogs {
    private Long id;

    private String time;

    private String address;

    private String userName;

    private String content;
}
