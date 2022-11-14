package com.hb0730.boot.admin.project.fy.entity;

import java.util.Date;
import lombok.Data;

@Data
public class FyDeviceTimes {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 设备id
    */
    private String deviceId;

    /**
    * 上线时间
    */
    private Date onlineTime;

    /**
    * 下线时间
    */
    private Date outlineTime;
}
