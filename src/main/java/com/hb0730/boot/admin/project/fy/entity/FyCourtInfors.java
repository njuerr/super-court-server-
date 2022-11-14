package com.hb0730.boot.admin.project.fy.entity;

import lombok.Data;

@Data
public class FyCourtInfors {
    private Long id;

    /**
    * 法院id
    */
    private String courtId;

    /**
    * 法院所属地区
    */
    private String courtZone;

    /**
    * 法院中文名称
    */
    private String courtName;

    /**
    * 法院状态 0红色表示离线 ，1蓝色表示故障，2绿色表示在线
    */
    private String courtState;

    /**
    * 法院区域排序
    */
    private Long courtSort;
}
