package com.tingtu.ax.admin.project.fy.entity;

import lombok.Data;

/**
 * @author Administrator
 */
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
