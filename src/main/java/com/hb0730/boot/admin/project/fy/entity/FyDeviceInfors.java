package com.hb0730.boot.admin.project.fy.entity;

import lombok.Data;

@Data
public class FyDeviceInfors {
    private Long id;

    /**
    * 法院设备ID
    */
    private String courtId;

    /**
    * 设备ID
    */
    private String deviceid;

    /**
    * 设备名称
    */
    private String deviceName;

    /**
    * 设备IP
    */
    private String deviceIp;

    /**
    * 控制URL
    */
    private String controlUrl;

    /**
    * 设备状态 0代表故障 1代表正常
    */
    private String deviceState;
}
