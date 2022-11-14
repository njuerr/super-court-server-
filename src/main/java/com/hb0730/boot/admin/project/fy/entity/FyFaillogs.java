package com.hb0730.boot.admin.project.fy.entity;

import lombok.Data;

@Data
public class FyFaillogs {
    private Long id;

    private String failid;

    private String reporttime;

    private String processtime;

    private String courtid;

    private String reportuser;

    private String processuser;

    private String failcontent;

    private String processcontent;

    private String deviceid;

    private String repair;
}
