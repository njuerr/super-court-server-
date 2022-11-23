package com.tingtu.ax.admin.project.fy.entity;

import com.tingtu.ax.admin.domain.model.entity.BaseDomain;
import lombok.Data;

import java.util.Date;

@Data
public class FyDeviceTimes  extends BaseDomain {
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
