package com.hb0730.boot.admin.project.fy.vo;

import lombok.Data;

import java.util.Date;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-10 18:15
 **/

@Data
public class FailLogVo {

    /**
     * ID             uint   `gorm:"primarykey"`
     * Failid         string //故障ID
     * Reporttime     string //上报时间
     * Processtime    string //处理时间
     * Courtid        string //故障节点，用法院ID联连上表
     * Reportuser     string //上报用户
     * Processuser    string //处理用户
     * Failcontent    string //故障内容
     * Processcontent string //处理方法
     * Deviceid       string //设备ID
     * Repair         string //修复状态 0代表代修复，1代表完成
     */

    private Integer id;
    private String failId;
    private String reporttime;
    private String Processtime;
    private String courtId;
    private String reportUser;
    private String processUser;
    private String failContent;
    private String deviceId;
    private String repair;
}
