package com.tingtu.ax.admin.project.fy.dto;

import com.tingtu.ax.admin.domain.model.dto.BaseDTO;
import lombok.Data;

import java.util.Date;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-23 13:57
 **/
@Data
public class LineDTO extends BaseDTO {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 设备id
     */
    private String deviceId;
    private String deviceName;

    /**
     * 上线时间
     */
    private Date onlineTime;
    private String onlineTimeStr;

    /**
     * 下线时间
     */
    private Date outlineTime;
    private String outlineTimeStr;
}
