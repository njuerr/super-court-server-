package com.tingtu.ax.admin.project.fy.entity;

import com.tingtu.ax.admin.domain.model.entity.BaseDomain;
import lombok.Data;

@Data
public class FyFaillogs extends BaseDomain {
    private Long id;

    private String failid;

    private String reporttime;

    private String processtime;

    private String courtid;

    private String reportuser;

    private String processuser;

    private String failcontent;

    private String processcontent;

    private String deviceid;

    private String repair;

    private Integer delFlag;

    public static final String FAILID = "failid";

}
