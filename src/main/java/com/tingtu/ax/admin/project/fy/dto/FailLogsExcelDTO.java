package com.tingtu.ax.admin.project.fy.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.tingtu.ax.admin.domain.model.excel.ExcelDomain;
import lombok.*;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-21 14:38
 **/
@Data
public class FailLogsExcelDTO extends ExcelDomain {
    @ExcelProperty(value = "id", index = 0)
    private Long id;
    @ExcelProperty(value = "故障id", index = 1)
    private String failid;
    @ExcelProperty(value = "上报时间", index = 2)
    private String reporttime;
    @ExcelProperty(value = "处理时间", index = 3)
    private String processtime;
    @ExcelIgnore
    private String courtid;
    @ExcelIgnore
    private String reportuser;
    @ExcelIgnore
    private String processuser;
    @ExcelProperty(value = "法院", index = 4)
    private String courtName;
    @ExcelProperty(value = "上报人", index = 5)
    private String reportuserName;
    @ExcelProperty(value = "处理人", index = 6)
    private String processuserName;
    @ExcelProperty(value = "故障内容", index = 7)
    private String failcontent;
    @ExcelProperty(value = "处理意见", index = 8)
    private String processcontent;

}
