package com.hb0730.boot.admin.project.fy.entity;

import lombok.Data;

@Data
public class FyDeviceChannels {
    private Long id;

    private String deviceid;

    private String channelName;

    /**
    * 处理器中的通道 名称
    */
    private String channelCode;
}
