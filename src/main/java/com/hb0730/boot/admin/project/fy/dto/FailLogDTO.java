package com.hb0730.boot.admin.project.fy.dto;

import com.hb0730.boot.admin.domain.model.dto.BaseDTO;
import lombok.Data;

import java.util.Date;

/**
 * @program: boot-admin
 * @description:
 * @author: ax
 * @create: 2022-11-21 14:10
 **/
@Data
public class FailLogDTO extends BaseDTO {
    private Long id;
    private String failid;

    private String reporttime;

    private String processtime;

    private String courtid;
    private String courtName;

    private String reportuser;

    private String reportuserName;

    private String processuser;

    private String processuserName;

    private String failcontent;

    private String processcontent;

    private String deviceid;

    private String repair;
    private Date updateTime;
}
