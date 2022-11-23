package com.hb0730.boot.admin.project.fy.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.hb0730.boot.admin.domain.model.excel.ExcelDomain;
import lombok.Data;

import java.util.Date;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-23 14:03
 **/
@Data
public class LineExcelDTO extends ExcelDomain {
    /**
     * 主键
     */
    @ExcelProperty(value = "id", index = 0)
    private Integer id;

    /**
     * 设备id
     */
    @ExcelIgnore
    private String deviceId;
    @ExcelProperty(value = "法院", index = 1)
    private String deviceName;

    /**
     * 上线时间
     */
    @ExcelProperty(value = "上线时间", index = 2)
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date onlineTime;

    /**
     * 下线时间
     */
    @ExcelProperty(value = "下线时间", index = 3)
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date outlineTime;
}
